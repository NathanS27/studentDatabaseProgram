package database;

public class Grad extends Student {

	private String major;
	
	
	public Grad(String nm, String num,String maj) throws FormatException {
		super(nm,num);
		if(maj.isEmpty()) {
			throw new FormatException("Major cannot be blank",3);
		}
		major=maj;
	}
	public String getmajor() {
		return major;
	}
	@Override
	public String toString() {
		return super.toString()+String.format("Major: %s", major);
	}
	public boolean compare(Grad g) {
		return g.getmajor().equalsIgnoreCase(major);
	}
}
