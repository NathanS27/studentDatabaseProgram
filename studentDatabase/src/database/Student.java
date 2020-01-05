package database;

import java.util.*;

public class Student extends Person{

	private String idNum;
	private static int[] idNums = new int[10];
	private static int students =0;
	
	
	public Student(String nm, String num) throws FormatException {
		super(nm);
		if(num.isEmpty()) {
			Random rand = new Random();
			num=String.format("%4d", rand.nextInt(10000));
			try {
				Integer.parseInt(num);
			}
			catch(NumberFormatException e) {
			num=String.format("%4d", rand.nextInt(10000));
			}
		}
		onlyNumeric(num);
		for(int n:idNums) {
			if(n==Integer.parseInt(num)) {
				throw new FormatException("Cannot repeat Student ID",2);
			}
		}
		idNum=num;
		idNums[students]=Integer.parseInt(idNum);
	}
	
	private void onlyNumeric(String str) throws FormatException {
		for(char c: str.toCharArray()) {
			if(Character.isAlphabetic(c)|| c=='-'||c=='.') {
				throw new FormatException("Must be a positive integer",2);
			}
		}
	}
	
	public String getIdNum() {
		return idNum;
	}
	@Override
	public String toString() {
		return super.toString()+String.format("Student ID: %s \n", idNum);
	}
}
