package database;

public class Student extends Person{

	private int idNum;
	
	public Student(String nm,int num) {
		super(nm);
		idNum=num;
	}
	
	public int getIdNum() {
		return idNum;
	}
	@Override
	public String toString() {
		return super.toString()+" "+idNum;
	}
}
