package database;

import javax.swing.*;
import BreezySwing.*;

public class addDlg extends GBDialog {
	
	JComboBox level = addComboBox(1,1,1,1);
	
	JFrame parentClass;
	
	public addDlg(JFrame parent,int type) {
		super(parent);
		level.addItem("Undergrad");
		level.addItem("Grad");
		setTitle("Add");
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
	
	private void populate() {
	}
}