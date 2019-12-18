package database;

import javax.swing.*;
import BreezySwing.*;

public class addDlg extends GBDialog {
	
	JComboBox level = addComboBox(1,1,1,1);
	
	JFrame parentClass;
	
	public addDlg(JFrame parent,int type) {
		super(parent);
		level.addItem("Undergraduate");
		level.addItem("Graduate");
		setTitle(format(type));
		setDlgCloseIndicator("Cancel");
		setSize(400, 200);
		setLocationRelativeTo(null);
		parentClass=parent;
	}
	
	public void buttonClicked(JButton buttonObj) {
		
	}
	
	private String format(int type) {
		if(type==1) {
			level.setVisible(false);
			return"Add Undergrad";
		}
		if(type==2) {
			level.setVisible(false);
			return"Add Grad";
		}
		return "Add";
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(parentClass,str);
		display.setVisible(true);
	}
	
	private void populate() {
	}
}