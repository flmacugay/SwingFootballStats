package com.ordermate.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Froilan
 */
public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private final String[] columnNames={"Pos", "Team", "P", "W", "D", "L", "For", "Agn", "Max", "Min"};
    private Object[][] data;
    
    public void loadData() throws FileNotFoundException{
		data=DataLoader.initData();
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString(); 
    }
    
    private static class DataLoader {
        private static final String fileName="football.dat";
        private static Object[][] initData() throws FileNotFoundException {
            List<String []> list = new LinkedList<>();
            try (Scanner s=new Scanner(new File(fileName))){
                while(s.hasNextLine()){
                    String [] splitStr=s.nextLine().split("\\t");
                    if(splitStr[0].matches("\\d{1,2}")) list.add(splitStr);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TableModel.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
            return list.toArray(new String[0][0]);
        }
    }
}
