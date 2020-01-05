package database;

public class Person {

	private String name;
	
	public Person(String nm) throws FormatException {
		if(nm.isEmpty()) {
			throw new FormatException("Name Cannot be blank",1);
		}
		name=nm;
	}
	
	public String getName() {
		return name;
	}
	public String toString() {
		return String.format("Name: %s \n", name);
	}
}
