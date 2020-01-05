package database;

public class UnderGrad extends Student {
	
	private int gradeLevel;
	
	
	public UnderGrad(String nm, String num,int level) throws FormatException {
		super(nm,num);
		gradeLevel=level;
	}
	public int getGradeLevel() {
		return gradeLevel;
	}
	public String gradeLevelPrint() {
		if(gradeLevel==0) {
			return "Freshman";
		}
		else if(gradeLevel==1) {
			return "Sophmore";
		}
		else if(gradeLevel==2) {
			return "Junior";
		}
		else if(gradeLevel==3) {
			return "Senior";
		}
		return "";
	}
	
	@Override
	public String toString() {
		return super.toString()+String.format("Grade: %s", gradeLevelPrint());
	}
	
	public boolean compare(UnderGrad u) {
		return u.getGradeLevel()==gradeLevel;
	}
}
