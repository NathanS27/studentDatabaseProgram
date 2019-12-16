package database;

public class Student extends Person{

	private String name;
	private int idNum;
	
	public Student(String nm,int num) {
		super(nm);
		idNum=num;
		name=nm;
	}
	
	public int getIdNum() {
		return idNum;
	}
}
