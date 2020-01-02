package database;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BreezySwing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class DisplayDlg extends GBDialog {
	
		JPanel dataLayout = addPanel(2,1,3,2);
		JTable dataTable = null;
		DefaultTableModel dataModel = null;
		
		ButtonGroup schoolLevel = new ButtonGroup();
	    JRadioButton person  = addRadioButton ("Person", 1,1,1,1);
	    JRadioButton student  = addRadioButton ("Student", 1,2,1,1);
	    JRadioButton underGrad   = addRadioButton ("Under Graduate", 1,3,1,1); 
	    JRadioButton grad = addRadioButton ("Graduate", 1,4,1,1);

	    private ChangeListener cl = new ChangeListener() {
	    	@Override
	    	public void stateChanged(ChangeEvent e) {
	    		JRadioButton source = (JRadioButton) e.getSource();
	    		
	    		if(source==person && person.isSelected()) {
	 
	    		}
					
				if(source==student && student.isSelected()) {
					
				}
				if(source==underGrad && underGrad.isSelected()) {
					
				}
				if(source==grad && grad.isSelected()) {
					
				}
	    	}
	    };
	    
	    JFrame parentClass;
		
		public DisplayDlg(JFrame parent) {
			super(parent);
			setTitle("display");
			schoolLevel.add(person);
			schoolLevel.add(student);
			schoolLevel.add(underGrad);
			schoolLevel.add(grad);
			person.addChangeListener(cl);
			student.addChangeListener(cl);
			underGrad.addChangeListener(cl);
			grad.addChangeListener(cl);
			person.setSelected(true);
			setDlgCloseIndicator("Cancel");
			setSize(400, 200);
			setLocationRelativeTo(null);
			parentClass=parent;
			
		}
		
		public void buttonClicked(JButton buttonObj) {
			
			
		}
		
		private void errorMsg(String str) {
			ErrorDlg display = new ErrorDlg(parentClass,str);
			display.setVisible(true);
		}
		
		private void createTable() {
			String[] columnNames = {"Title", "Author", "Status","Borrower", "Checked Out","Due Date"};
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
	        dataTable.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
	     

			// Add the scrollPane to the panel and put it in the center so it uses the full panel
			JScrollPane scrollPane = new JScrollPane(dataTable);
			dataLayout.add(scrollPane,BorderLayout.CENTER);
			dataTable.disable();
		}
		
		private void displayBook(Book b) {
			String[] dataRow = new String[6];
			dataRow[0] = b.getTitle();
			dataRow[1] = b.getAuthor();
			dataRow[2] = statusCheck(b.isAvailable());
			if(!b.isAvailable()) {
				dataRow[3] = b.getBorrower();
				dataRow[4] = b.getCheckOutDate().toString();
				dataRow[5] = overdueFormat(b.isOverdue(),b);
			}
			
			dataModel.addRow(dataRow);
		}
}
