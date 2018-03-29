package exceptiontimes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDriver {

	public static void main(String[] args) {

		try {
			doSomething(-1);
		} catch (DoSomethingException e) {
			
			System.out.println("Can't run do something");
			System.out.println(e.getCauseCount());
		}
		
		
		
		
		boolean fileOK = false;
		String filename = "";
		Scanner kb = new Scanner(System.in);
		Scanner data = null;

		do {
			try {
				System.out.println("Please enter filename");
				filename = kb.nextLine();
				data = new Scanner(new File(filename));
				fileOK = true;
			} catch (FileNotFoundException e) {
				if (filename.equalsIgnoreCase("Q")) {
					break;
				}
				System.out.println("Not able to open file " + filename);
				System.out.println("Please try again or enter \"Q\" to stop \n");
			}
		} while (fileOK == false);

		kb.close();

		int x = 0;
		int line = 1;
		if (data != null) {
			while (data.hasNext()) {
				try {
					x = data.nextInt();
					System.out.println("Line " + line + ": " + x);
					
				} catch (InputMismatchException e) {
					String badData = data.next();
					System.out.println("Unable to parse line " + 
					line + " containing: " + badData);
				} finally {
					line++;
				}
			}
		}

	}
	
	public static void doSomething(int intakeValue) throws DoSomethingException{
		
		if (intakeValue < 0) {
			throw new DoSomethingException(intakeValue);
		}
		
	}

}
