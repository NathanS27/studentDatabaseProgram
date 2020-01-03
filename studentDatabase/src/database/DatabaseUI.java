package database;

import BreezySwing.*;

import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class DatabaseUI extends GBFrame {

	JMenuItem add = addMenuItem("edit","New");
	JMenuItem addUGrad = addMenuItem("edit","New UnderGrad");
	JMenuItem addGrad = addMenuItem("edit","New Grad");
	JMenuItem display = addMenuItem("edit","Display");
	
	private ArrayList<Person> people = new ArrayList<Person>();
	
	public void menuItemSelected(JMenuItem menuItem){
		int type=0;
		if(menuItem==display) {
			DisplayDlg dlg = new DisplayDlg(this,people);
			dlg.setVisible(true);
		}
		else{
			if(menuItem==addUGrad) {
				type=1;
			}
			if(menuItem==addGrad) {
				type=2;
			}
			addDlg dlg = new addDlg(this,type,people);
			dlg.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		JFrame frm = new DatabaseUI();
		frm.setSize(600, 400);
		frm.setTitle("Student Database");
		frm.getContentPane().setBackground(new Color(54,134,249));
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
	
	private void errorMsg(String str) {
		ErrorDlg dlg = new ErrorDlg(this,str);
		dlg.setVisible(true);
	}
}
