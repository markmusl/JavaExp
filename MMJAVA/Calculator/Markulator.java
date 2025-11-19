package Calculator;

import Interface.Menu;

import java.util.Scanner;

public class Markulator {
	public static Scanner Scanner = new Scanner(System.in);

    public static void ResultPrint (float x, float y, char operator) {

		Float result = (float) 0.0;

		// Possible Cases 
		switch (operator) {
			case '+' -> result = x + y;
			case '-' -> result = x - y;
			case '*', 'x' -> result = x * y;	

			case '/' -> {
				while (y == 0) {
					System.out.println("The second number cannot be 0.\n");
					System.out.print("Second value: ");					
					y = Scanner.nextFloat();
				}

				result = x / y;
			}
				
			default -> {}
		}

		System.out.println();
		System.out.printf("%.1f %c %.1f = %.2f", x, operator, y, result);
		
		System.out.println("\n--------------------");
	}

	public static void run() {
		Menu.ProgramHeader("Markulator", 10, 11);
		System.out.println("[0] Back");

		Scanner.nextLine();

		while(true) {
			System.out.println("\n--------------------");
		
			Scanner.nextLine();

			// First Number
			System.out.print("1st Number | ");
			Float x = Scanner.nextFloat();

			if (x == 0) Menu.run();

			// Operator
			System.out.print("Operator | ");
			char op = Scanner.next().charAt(0);

			while (op != '+' && op != '-' && op != '*' && op != 'x'&& op != '/') {
				System.out.println("Error! Incorrect operator.");

				System.out.print("Operator | ");
				op = Scanner.next().charAt(0);
			}

			// Second Number
			System.out.print("2nd Number | ");
			Float y = Scanner.nextFloat();

			ResultPrint(x, y, op);
			
			System.out.println("\n");
		}
	}
}
