package database;

import BreezySwing.*;

import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class DatabaseUI extends GBFrame {
	
	JButton newBtn = addButton("new",1,1,1,1);
	JButton populate = addButton("Populate (10)",1,2,1,1);
	JButton display = addButton("display",1,3,1,1);
	
	private ArrayList<Person> people = new ArrayList<Person>();
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==display) {
			DisplayDlg dlg = new DisplayDlg(this,people);
			dlg.setVisible(true);
		}
		else if(buttonObj==populate) {
			try {
			people.add(new Grad("Robby","","Math"));
			people.add(new Person("Person"));
			people.add(new UnderGrad("Rodrik","",2));
			people.add(new Student("Student",""));
			people.add(new Grad("Frank","","math"));
			people.add(new UnderGrad("Bob","",2));
			people.add(new Student("Mike",""));
			people.add(new Grad("Grad","","English"));
			people.add(new UnderGrad("UnderGrad","",3));
			people.add(new UnderGrad("Robert","",3));
			}
			catch(FormatException e) {
				//never gonna happen
			}
			populate.setVisible(false);
			newBtn.setVisible(false);
		}
		else if(buttonObj==newBtn) {
			if(people.size()<10) {
				addDlg dlg = new addDlg(this,people);
				dlg.setVisible(true);
				populate.setVisible(false);
			}
			else {
				newBtn.setVisible(false);
				errorMsg("Max 10");
			}
		}
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(this,str);
		display.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrame frm = new DatabaseUI();
		frm.setSize(300, 80);
		frm.setTitle("Student Database");
		frm.getContentPane().setBackground(new Color(54,134,249));
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
}
