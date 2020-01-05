package database;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.*;
import BreezySwing.*;

public class DisplayDlg extends GBDialog {
		
		ButtonGroup schoolLevel = new ButtonGroup();
	    JRadioButton person  = addRadioButton ("Person", 1,1,1,1);
	    JRadioButton student  = addRadioButton ("<html> <font color='red'> Student </font></html>", 1,2,1,1);
	    JRadioButton underGrad   = addRadioButton ("<html> <font color='green'> Under Graduate </font></html>", 1,3,1,1); 
	    JRadioButton grad = addRadioButton ("<html> <font color='purple'> Graduate </font></html>", 1,4,1,1);
	    
	    ArrayList<Person> People;
	    Object currentObj;
	    JFrame parentClass;
		
		JList personList = addList(2,1,2,1);
		JTextArea personInfo = addTextArea("",2,3,2,1);
		JButton close = addButton("Close",3,3,1,1);
		
		
	    private ChangeListener cl = new ChangeListener() {
	    	@Override
	    	public void stateChanged(ChangeEvent e) {
	    		JRadioButton source = (JRadioButton) e.getSource();
	    		
	    		if(source==person && person.isSelected()) {
	    			currentObj=null;
	    			addToList(People);
	    			personInfo.setText("");
	    		}
					
				if(source==student && student.isSelected()) {
					addToList(displayTypeList(Student.class));
					personInfo.setText("");
				}
				if(source==underGrad && underGrad.isSelected()) {
					addToList(displayTypeList(UnderGrad.class));
					personInfo.setText("");
				}
				if(source==grad && grad.isSelected()) {
					addToList(displayTypeList(Grad.class));
					personInfo.setText("");
				}
	    	}
	    };
		
		public void listItemSelected (JList listObj){
			int index = personList.getSelectedIndex(); 
			// if something is actually selected
			if (index >= 0){
				if(student.isSelected()) {
					display(displayTypeList(Student.class).get(index));
				}
				else if(underGrad.isSelected()) {
					display(displayTypeList(UnderGrad.class).get(index));
				}
				else if(grad.isSelected()) {
					display(displayTypeList(Grad.class).get(index));
				}
				else {
					display(People.get(index));
				}
			}
		}

		public void listDoubleClicked(JList listObj,String itemClicked) {
		}

		public void buttonClicked(JButton buttonObj) {
			dispose();
		}
		
		private void display(Person p) {
			if(p.getClass().equals(Person.class)||p.getClass().equals(Student.class)) {
				personInfo.setText(p.toString());
			}
			else if(p.getClass().equals(UnderGrad.class)) {
				personInfo.setText(p.toString()+compareUGrad((UnderGrad)p));
			}
			else if(p.getClass().equals(Grad.class)) {
				personInfo.setText(p.toString()+compareGrad((Grad)p));
			}
		}
		
		private String compareUGrad(UnderGrad p) {
			int match=0;
			String str="\n\nSame grade Level as: \n\n";
			for(Person temp:displayTypeList(UnderGrad.class)) {
				if(p.compare((UnderGrad)temp)) {
					if(!p.equals(temp)) {
						match++;
						str+= "\n"+temp.toString()+"\n";
					}
				}
			}
			if(match>0) {
				return str;
			}
			return "";
		}
		
		private String compareGrad(Grad p) {
			int match=0;
			String str="\n\nSame major  as: \n\n";
			for(Person temp:displayTypeList(Grad.class)) {
				if(p.compare((Grad)temp)) {
					if(!p.equals(temp)) {
						match++;
						str+= temp.toString()+"\n";
					}
				}
			}
			if(match>0) {
				return str;
			}
			return "";
		}
		
		private ArrayList<Person> displayTypeList(Object obj){
			currentObj=obj;
			ArrayList<Person> tempArr = new ArrayList<Person>();
			for(Person temp:People) {
				if(obj==Student.class) {
					if(temp.getClass().equals(obj)||temp.getClass().equals(UnderGrad.class)||temp.getClass().equals(Grad.class)) {
						tempArr.add(temp);
					}
				}
				else {
					if(temp.getClass().equals(obj)) {
						tempArr.add(temp);
					}
				}
			}
			return tempArr;
		}
		
		private void addToList(ArrayList<Person> list) {
			DefaultListModel model = (DefaultListModel) personList.getModel();
			model.clear();
			for(Person temp: list) {
				model.addElement(colorCodeName(temp));
			}
			//personList.setSelectedIndex(personList.getLastVisibleIndex());
		}
		
		private String colorCodeName(Person p) {
			if(p.getClass().equals(Student.class)) {
				return String.format("<html> <font color='red'> %s </font></html>", p.getName());
			}
			if(p.getClass().equals(UnderGrad.class)) {
				return String.format("<html> <font color='green'> %s </font></html>", p.getName());
			}
			if(p.getClass().equals(Grad.class)) {
				return String.format("<html> <font color='purple'> %s </font></html>", p.getName());
			}
			return p.getName();
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
			People=list;
			currentObj=null;
			person.setSelected(true);
			personInfo.setFont(personInfo.getFont().deriveFont(18f));
			setDlgCloseIndicator("Cancel");
			setSize(800, 500);
			setLocationRelativeTo(null);
			parentClass=parent;
			
		}
}
