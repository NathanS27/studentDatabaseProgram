package database;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.*;

import BreezySwing.*;

public class displayPersonDlg extends GBDialog {
	
	JPanel dataLayout = addPanel(1,1,3,2);
	JTable dataTable = null;
	DefaultTableModel dataModel = null;
	
	JButton back = addButton("Back",3,3,1,1);
	
	JFrame parentFrame;
	
	public displayPersonDlg(JFrame parent,Person p) {
		super(parent);
		setTitle(p.getName());
		setDlgCloseIndicator("Close");
		setSize(800, 120);
		setLocationRelativeTo(null);
		parentFrame=parent;
		createTable();
		displayPerson(p);
	}
	
	private void createTable() {
		String[] columnNames = {"Name", "Student ID", "Level","Major"};
		String[][] data = {{"","","","","",""}};

		// Set the layout mode of the data panel
		dataLayout.setLayout(new BorderLayout());
		
		// Create the placeholder table and put it in a scroll pane
		dataTable = new JTable (data,columnNames);
		dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(columnNames);
        dataTable.setModel(dataModel);
        
        //sets the alignment
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        dataTable.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        dataTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        dataTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        dataTable.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
     

		// Add the scrollPane to the panel and put it in the center so it uses the full panel
		JScrollPane scrollPane = new JScrollPane(dataTable);
		dataLayout.add(scrollPane,BorderLayout.CENTER);
		dataTable.disable();
	}
	
	private void displayPerson(Person p) {
		String[] dataRow = new String[6];
		dataRow[0] =p.getName();
		dataRow[1] ="N/A";
		dataRow[2] ="N/A";
		dataRow[3] ="N/A";
		
		dataModel.addRow(dataRow);
	}
	
	
	
	
	
	public void buttonClicked(JButton buttonObj) {
		dispose();
	}
}

