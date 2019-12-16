package database;

import BreezySwing.*;

import java.awt.Color;
import javax.swing.*;

public class DatabaseUI extends GBFrame {

	JMenuItem add = addMenuItem("edit","New");
	JMenuItem addUGrad = addMenuItem("edit","New UnderGrad");
	JMenuItem addGrad = addMenuItem("edit","New Grad");
	JMenuItem display = addMenuItem("edit","Display");
	
	
	public void menuItemSelected(JMenuItem menuItem){
		int type =0;
		if(menuItem==addUGrad) {
			type=1;
		}
		if(menuItem==addGrad) {
			type=2;
		}
		addDlg dlg = new addDlg(this,type);
		dlg.setVisible(true);
		
	}
	public static void main(String[] args) {
		JFrame frm = new DatabaseUI();
		frm.setSize(600, 400);
		frm.setTitle("Student Database");
		frm.getContentPane().setBackground(new Color(216,23,55));
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
}
