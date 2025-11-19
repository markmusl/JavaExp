package Classroom;

import java.util.HashMap;
import java.util.Map;

import Interface.Menu;

import java.util.Scanner;

public class ClassroomHash {
	public static Scanner Scanner = new Scanner(System.in);
    
    // "Classroom" | Hash Version	
	public static void ClassroomHashPrint(int ClassesQuantity, int formatValue) {
		System.out.println("\n");	

		String format = "%-" + formatValue + "s"; 
		
		for (int i = 0; i < ClassesQuantity; i++) {
			String ClassIndex = "LI" + (i + 1);
			System.out.printf(format, ClassIndex);
		}

		System.out.println();

		for (int i = 0; i < ClassesQuantity; i++) {
			int ClassQuantity = 23;
			System.out.printf(format, ClassQuantity);
		}

		System.out.println("\n\n");
	}

	public static void run () {
		Menu.ProgramHeader("Classroom [Hash Version]", 10, 11);
		Map<String, Integer> ClassesList = new HashMap<>();

		int ClassCapacity = 0; 

		System.out.print("Classes Quantity: ");
		int ClassesQuantity = Scanner.nextInt();


		while (ClassesQuantity < 1 || ClassesQuantity > 5) { 
			System.out.println("Error. The value must include 1 - 5.");
			System.out.print("Classes Quantity: ");
			ClassesQuantity = Scanner.nextInt();
		}

		System.out.println("\n\n");

		for (int i = 0; i < ClassesQuantity; i++) {
			System.out.print("LI" + (i + 1) + ": ");
			ClassCapacity = Scanner.nextInt();


			while (ClassCapacity < 1 || ClassCapacity > 40) { 
				System.out.println("Error. The value must include 1 - 40.");
				System.out.print("LI" + (i + 1) + ": ");
				ClassCapacity = Scanner.nextInt();
			}

			String ClassName = "LI" + (i + 1);

			ClassesList.put(ClassName , ClassCapacity);
		}

		ClassroomHashPrint(ClassesQuantity, 6);
		ClassroomHashPrint(ClassesQuantity, 4);

		Menu.RepeatMenu(() -> run());
	}
}
