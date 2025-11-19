package Classroom;

import java.util.ArrayList;
import java.util.Scanner;

import Interface.Menu;

public class ClassroomArray {
    public static Scanner Scanner = new Scanner(System.in);


	public static void ClassroomArrayPrint(int formatValue, ArrayList ClassIndexList, ArrayList ClassCapacityList) {

		System.out.println("\n\n");	
		String format = "%-" + formatValue + "s"; 
		
		for (int i = 0; i < ClassIndexList.size(); i++) System.out.printf(format, ClassIndexList.get(i));
		
		System.out.println();

		for (int i = 0; i < ClassIndexList.size(); i++) System.out.printf(format, ClassCapacityList.get(i));
		System.out.println("\n\n");
	}
	

	public static void run() {
		Menu.ProgramHeader("Classroom [Array Version]", 10, 11);

		ArrayList<String> ClassIndexList = new ArrayList<>();
		ArrayList<Integer> ClassCapacityList = new ArrayList<>();

		System.out.print("Class Quantity: ");
		int ClassesQuantity = Scanner.nextInt();

		for (int i = 0; i < ClassesQuantity; i++) {
			String ClassIndex = "LI" + (i + 1);
			System.out.print(ClassIndex + ": ");

			int ClassCapacity = Scanner.nextInt();

			ClassIndexList.add(ClassIndex);
			ClassCapacityList.add(ClassCapacity);
		}

		for (int loop = 4; loop <= 8; loop += 2) ClassroomArrayPrint(loop, ClassIndexList, ClassCapacityList);

		Menu.RepeatMenu(() -> run());
	}
}
