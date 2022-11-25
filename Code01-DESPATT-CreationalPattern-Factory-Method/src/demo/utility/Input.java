package demo.utility;

import java.io.*;

public class Input {
	private static BufferedReader getReader() {
		return new BufferedReader(
			new InputStreamReader(System.in));
	}
	
	public static String getString(String message) {
		String input = null;
		
		try {
			System.out.print("Enter a " + message + ": ");
			input = getReader().readLine();
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return input;
	}
}


