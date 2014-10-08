package com.ordermate.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import com.ordermate.model.FootballStatsService;
import com.ordermate.model.TableModel;
import com.ordermate.view.FootballStatsView;

/**
 *
 * @author Froilan
 */
public class FootballStatsController {
    
    private FootballStatsView view;
    private FootballStatsService model;

    public FootballStatsController(FootballStatsView view, FootballStatsService model) {
        this.view = view;
        this.model = model;
        this.view.addCalculateListener(new CalculateListener());
        
        loadTable(this.view, new TableModel());
    }
    
    private void loadTable(final FootballStatsView view, TableModel tblModel){
        
        try {
            tblModel.loadData();
        } catch (FileNotFoundException ex) {
            showErrorMessage("Unable to load file.");
            Logger.getLogger(FootballStatsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        view.getStatsTbl().setModel(tblModel);
        view.setPreferredColumnsWidth(view.getStatsTbl());
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.setVisible(true);
            }
        });
    }
    
    private class CalculateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new SwingWorker<Integer, Integer>() {
                @Override
                protected Integer doInBackground() throws Exception {
                    try {
                        model.calculateMostConsistentTeam((TableModel) view.getStatsTbl().getModel());
                    } catch (NumberFormatException ex) {
                        showErrorMessage("Unable to calculate.");
                        Logger.getLogger(FootballStatsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    view.setCalcResult(model.getMostConsistentTeam());
                    return 0;
                }
            }.execute();
        }
    }
    
    private void showErrorMessage(String errMsg){
        view.displayErrorMsg(errMsg);
    }
    
}
