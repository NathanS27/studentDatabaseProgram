package database;

public class UnderGrad extends Student {
	
	private int gradeLevel;
	
	public UnderGrad(String nm, int num,int level) {
		super(nm,num);
	}
	public int getGradeLevel() {
		return gradeLevel;
	}
}
