package Games;

import java.util.Scanner;

import Interface.Menu;

public class KrestikiNoliki {
    public static Scanner Scanner = new Scanner(System.in);


	static char[][] board = {
		{' ', ' ', ' '}, 
		{' ', ' ', ' '}, 
		{' ', ' ', ' '}, 
	}; 


	public static void Settings () {

		System.out.println("BOARD SIZE");

		for (int index = 1, size = 3; size <= 10; index++, size++) {
			System.out.printf("%s | %sx%s\n", index, size, size);
		}

		System.out.print("\n\nOption: ");
	}


	public static void run () {
		Menu.ProgramHeader("Krestiki Noliki", 18, 11);
		
		System.out.println("1 | Start");
		System.out.println("2 | Board Size");

		System.out.println();

		System.out.println("0 | Exit");

		System.out.print("\n\nOption: ");

		while (true) {
			int userOption = Scanner.nextInt();

			switch (userOption) {
				case 1 -> GameRun();
				case 2 -> Settings();

				default -> System.out.print("Unkown Option. Try again: ");
			} 
		}
	}



	public static void showBoard() {
		System.out.println("-------------");

		for (int columnSize = 0; columnSize < board.length; columnSize++) {
				
			// Lines
			System.out.print("|");
			for (int lineSize = 0; lineSize < board[columnSize].length; lineSize++) {
				System.out.print(" " + board[columnSize][lineSize] + " |");
			}

			System.out.println("\n-------------");	
		}
	}



	public static boolean Verification (char XO, String player) {
		if (board[0][0] == XO && board[1][1] == XO && board[2][2] == XO) {
			System.out.println(player + "wins!");
			return true;
		}

		if (board[0][2] == XO && board[1][1] == XO && board[2][0] == XO) {
			System.out.println(player + "wins!");
			return true;
		}

		return false;
	}



	public static void playerTurn (char XO, String name) {
		System.out.printf("\n\n%s's turn!\n\n", name);

		// Column
		System.out.print("Column: ");
		int column = Scanner.nextInt();

		// Line
		System.out.print("Line: ");
		int line = Scanner.nextInt();
	
		board[line - 1][column - 1] = XO; 

		if(Verification(XO, name)) {
			System.out.println("test");
			Menu.RepeatMenu(() -> run());
		}
		showBoard();

		Scanner.nextLine();
	}



	public static void GameRun () {
		Scanner.nextLine();

		System.out.print("1st Player's name: ");
		String name1 = Scanner.nextLine();

		System.out.print("2nd Player's name: ");
		String name2 = Scanner.nextLine();
		
		while (true) {
			playerTurn('x', name1);
			playerTurn('o', name2);
		}
	}
}
