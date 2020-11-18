package at.byh.tan;

import java.util.Random;

public class TAN {

	static int tanNummer = 0;
	
	public static void createTan() {
		Random r = new Random();
		tanNummer = r.nextInt(89999) + 10000;
		//System.out.println(tanNummer);
	}
	
	public static int getTan() {
		return tanNummer;
	}
}
