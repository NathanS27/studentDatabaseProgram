package database;

public class Grad extends Student {

	private String name;
	private int idNum;
	private String major;
	
	public Grad(String nm, int num,String maj) {
		super(nm,num);
		major=maj;
		idNum=num;
		name=nm;
	}
	
	public String getName() {
		return name;
	}
	public int getIdNum() {
		return idNum;
	}
	public String getmajor() {
		return major;
	}
}
