package database;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BreezySwing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class addDlg extends GBDialog {
	
	ButtonGroup schoolLevel = new ButtonGroup();
    JRadioButton person  = addRadioButton ("Person", 1,1,1,1);
    JRadioButton student  = addRadioButton ("Student", 1,2,1,1);
    JRadioButton underGrad   = addRadioButton ("Under Graduate", 1,3,1,1); 
    JRadioButton grad = addRadioButton ("Graduate", 1,4,1,1);
	
    JLabel nameLabel = addLabel("Name:",2,1,1,1);
    JTextField name = addTextField("",2,2,2,1);
    
    JLabel stuIdLabel = addLabel("Student ID:",3,1,1,1);
    JTextField studentID = addTextField("",3,2,2,1);
    
    JLabel gradeLabel = addLabel("Grade Level:",4,1,1,1);
    JComboBox grade = addComboBox(4,2,1,1);
    
    JLabel majorLabel = addLabel("Major:",4,1,1,1);
    JTextField major = addTextField("",4,2,2,1);
   
    private ArrayList<Person> people;
    
    int type;
    
    JButton add = addButton("Add",5,2,1,1);
    
    private ChangeListener cl = new ChangeListener() {
    	@Override
    	public void stateChanged(ChangeEvent e) {
    		JRadioButton source = (JRadioButton) e.getSource();
    		
    		if(source==person && person.isSelected()) {
				type=0;
    			stuIdLabel.setVisible(false);
				studentID.setVisible(false);
				
				gradeLabel.setVisible(false);
				grade.setVisible(false);
				
				majorLabel.setVisible(false);
				major.setVisible(false);
			}
			if(source==student && student.isSelected()) {
				type=1;
				stuIdLabel.setVisible(true);
				studentID.setVisible(true);
				
				gradeLabel.setVisible(false);
				grade.setVisible(false);
				
				majorLabel.setVisible(false);
				major.setVisible(false);
			}
			if(source==underGrad && underGrad.isSelected()) {
				type=2;
				stuIdLabel.setVisible(true);
				studentID.setVisible(true);
				
				gradeLabel.setVisible(true);
				grade.setVisible(true);
				
				majorLabel.setVisible(false);
				major.setVisible(false);
			}
			if(source==grad && grad.isSelected()) {
				type=3;
				stuIdLabel.setVisible(true);
				studentID.setVisible(true);
				
				gradeLabel.setVisible(false);
				grade.setVisible(false);
				
				majorLabel.setVisible(true);
				major.setVisible(true);
			}
    	}
    };
    
    JFrame parentClass;
	
	public addDlg(JFrame parent, ArrayList<Person> p) {
		super(parent);
		people=p;
		setTitle(format(type));
		getContentPane().setBackground(new Color(84,134,249));
		schoolLevel.add(person);
		schoolLevel.add(student);
		schoolLevel.add(underGrad);
		schoolLevel.add(grad);
		person.addChangeListener(cl);
		student.addChangeListener(cl);
		underGrad.addChangeListener(cl);
		grad.addChangeListener(cl);
		grade.addItem("Freshman");
		grade.addItem("Sophmore");
		grade.addItem("Junior");
		grade.addItem("Senior");
		person.setSelected(true);
		
		setDlgCloseIndicator("Cancel");
		setSize(400, 200);
		setLocationRelativeTo(null);
		parentClass=parent;
		
	}
	
	public void buttonClicked(JButton buttonObj) {
		try {
			if(type==0) {
				people.add(new Person(name.getText()));
			}
			else if(type==1) {
				//TODO error check ID num
				people.add(new Student(name.getText(),studentID.getText()));
			}
			else if(type==2) {
				people.add(new UnderGrad(name.getText(),studentID.getText(),grade.getSelectedIndex()));
			}
			else if(type==3) {
				people.add(new Grad(name.getText(),studentID.getText(),major.getText()));
			}
			dispose();
		}
		catch(FormatException e) {
			errorMsg(e.getMessage());
			switch(e.error) {
			case 1:
				name.setText("");
				name.grabFocus();
				break;
			case 2:
				studentID.setText("");
				studentID.grabFocus();
				break;
			case 3:
				major.setText("");
				major.grabFocus();
			}
		}
		
	}
	
	private String format(int type) {
		if(type==1) {
			return"Add Undergrad";
		}
		if(type==2) {
			return"Add Grad";
		}
		return "Add";
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(parentClass,str);
		display.setVisible(true);
	}
}