package Classroom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Interface.Menu;


public class Inovar {
    public static Scanner Scanner = new Scanner(System.in);


	public static void Option(int index, String title, boolean line) {

		if (line == true) {
			System.out.printf("\n  [%d] %s\n", index, title);
		} else {
			System.out.printf("  [%d] %s\n", index, title);
		}
	}
	
    public static void run() {
		Menu.ProgramHeader("Inovar", 19, 11);

		Option(1, "Students List", false);
		Option(2, "Add Student", false);

		Option(3, "All Subjects", true);
		Option(4, "Add Subject", false);		

		Option(0, "Exit", true);				

		System.out.print("  Option: ");

		while (true) {
			int userOption = Scanner.nextInt();

			switch (userOption) {
				case 1 -> StudentsList();	
				case 2 -> SubjectList();		
				case 3 -> AddStudent();

				default -> System.out.print("Unkown Option. Try again: ");
			}
		}
	}



	// Это список всех учеников и их оценок
	public static ArrayList<Object> studentsList = new ArrayList<>(); // Список учеников

	public static void SubjectList () {
		System.out.println("1 | View all Subjects");
		System.out.println("2 | Add new Subject");

		int option = Scanner.nextInt();

		switch (option) {
			case 1 -> System.out.println("View existed subjects");
			case 2 -> System.out.println("New Subject. Yeah");

			default -> System.err.println("Unkown Option.\nTry again: ");
		}
	}


	public static ArrayList<String> subjectList = new ArrayList<>(); // Список предметов	

	public static void AddStudent() {
		subjectList.add("Maths");
		subjectList.add("Design");
		subjectList.add("French");

		Scanner.nextLine();


		while (true) {

			Map<String, Object> studentInfo = new HashMap<>(); // Сведения об Ученике
			Map<String, Integer> gradesList = new HashMap<>(); // Предмет : Оценка

			System.out.print("Name: ");
			String studentName = Scanner.nextLine();

			if (studentName.equals("0")) Inovar.run();						

			studentInfo.put("Name", studentName);

			float averageGrade = 0;
			for (String subject : subjectList) {

				int grade;

				do {
					System.out.print(subject + ": ");
					grade = Scanner.nextInt();
					Scanner.nextLine();

					if (grade < 0 || grade > 20) System.out.println("Error! The range must include 0 - 20.");


				} while (grade < 0 || grade > 20);

				averageGrade += grade; 
				gradesList.put(subject, grade);
			}

			averageGrade /= subjectList.size();
			studentInfo.put("Average", averageGrade);
			studentInfo.put("Grades", gradesList);

			studentsList.add(studentInfo);
		}
	}


	public static void StudentsList() {
		for (Object student : studentsList) {
			System.out.println(student);
			System.out.println();
		}

		if (studentsList.isEmpty() == true) {
			System.out.println("\n  There are no students.");
		}
	}
}
