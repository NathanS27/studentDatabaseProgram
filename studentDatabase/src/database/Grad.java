package database;

public class Grad extends Student {

	private String name;
	private int idNum;
	private int gradeLevel;
	
	public Grad(String nm, int num,int level) {
		super(nm,num);
		gradeLevel=level;
		idNum=num;
		name=nm;
	}
	
	public String getName() {
		return name;
	}
	public int getIdNum() {
		return idNum;
	}
	public int getGradeLevel() {
		return gradeLevel;
	}
}
