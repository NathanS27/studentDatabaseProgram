package database;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import BreezySwing.*;

public class DisplayDlg extends GBDialog {
	
		JPanel dataLayout = addPanel(2,1,4,4);
		JTable dataTable = null;
		DefaultTableModel dataModel = null;
		
		ButtonGroup schoolLevel = new ButtonGroup();
	    JRadioButton person  = addRadioButton ("Person", 1,1,1,1);
	    JRadioButton student  = addRadioButton ("Student", 1,2,1,1);
	    JRadioButton underGrad   = addRadioButton ("Under Graduate", 1,3,1,1); 
	    JRadioButton grad = addRadioButton ("Graduate", 1,4,1,1);

	    ArrayList<Person> People;
	    
	    JFrame parentClass;
		
	    
	    private String[] personInfo;
		
		JList personList = addList(1,1,1,1);
		JButton close = addButton("Close",2,1,1,1);
		
		
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
	    
		
		public void listItemSelected (JList listObj){
			int index = personList.getSelectedIndex();
			// if something is actually selected
			if (index >= 0){  
				dispose();
				displayPersonDlg dlg = new displayPersonDlg(parentClass,People.get(index));
				dlg.setVisible(true);
			}
		}
			
		public void listDoubleClicked(JList listObj,String itemClicked) {
			System.out.println("DOUBLE CLICKED");
		}

		public void buttonClicked(JButton buttonObj) {
				dispose();
			}
	    
	    
		public DisplayDlg(JFrame parent, ArrayList<Person> list) {
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
			People=list;
			setDlgCloseIndicator("Cancel");
			setSize(400, 200);
			setLocationRelativeTo(null);
			parentClass=parent;
			
		}
		
		private void errorMsg(String str) {
			ErrorDlg display = new ErrorDlg(parentClass,str);
			display.setVisible(true);
		}
		
}
