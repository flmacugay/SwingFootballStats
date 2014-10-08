package com.ordermate.view;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Froilan
 */
public class FootballStatsView extends JFrame {

    private static final long serialVersionUID = 1L;
	
    private JButton calculateBtn;
    private JLabel headerLbl, msgLbl, consistentTeamLbl;
    private JPanel jPanel;
    private JScrollPane scrollPane;
    private JTable statsTbl;

    public FootballStatsView() {
        initComponents();
    }
    
    private void initComponents() {
        jPanel = new JPanel();
        headerLbl = new JLabel();
        consistentTeamLbl = new JLabel();
        calculateBtn = new JButton();
        msgLbl = new JLabel();
        scrollPane = new JScrollPane();
        statsTbl = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Ordermate");
        setLocationRelativeTo(null);

        headerLbl.setText("AFL Match Statistics");
        headerLbl.setFont(new Font("Tahoma", 1, 14));
        calculateBtn.setText("Click here");
        msgLbl.setText("Do you want to know the most consistent team?");

        statsTbl.setBorder(BorderFactory.createEtchedBorder());
        statsTbl.setEnabled(false);
        statsTbl.getTableHeader().setReorderingAllowed(false);
        statsTbl.getTableHeader().setFont(new Font("Tahoma", 1, 10));
        
        scrollPane.setViewportView(statsTbl);

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(msgLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calculateBtn)
                .addGap(34, 34, 34)
                .addComponent(consistentTeamLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(headerLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msgLbl)
                    .addComponent(calculateBtn)
                    .addComponent(consistentTeamLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public JTable getStatsTbl() {
        return statsTbl;
    }

    public void setCalcResult(String mostConsistentTeam){
        consistentTeamLbl.setText(mostConsistentTeam);
    }
    
    public void setPreferredColumnsWidth(JTable statsTbl){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        TableColumnModel cModel=statsTbl.getColumnModel();
        for(int i=0; i<cModel.getColumnCount(); i++){
            if(i==1) {
                cModel.getColumn(i).setPreferredWidth(100);
            } else{
                cModel.getColumn(i).setPreferredWidth(10);
            }
            if(i==1){
            } else {
                cModel.getColumn(i).setCellRenderer(centerRenderer);
            }
        }
    }
    
    public void addCalculateListener(ActionListener listenForCalcButton){
        calculateBtn.addActionListener(listenForCalcButton);
    }
    
    public void displayErrorMsg(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
