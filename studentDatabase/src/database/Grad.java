package database;

public class Grad extends Student {

	private String major;
	
	public Grad(String nm, int num,String maj) {
		super(nm,num);
		major=maj;
	}
	public String getmajor() {
		return major;
	}
	@Override
	public String toString() {
		return super.toString()+" "+major;
	}
}
