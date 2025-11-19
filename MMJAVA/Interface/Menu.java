package Interface;

import java.util.Scanner;

import Calculator.Markulator;
import Games.KrestikiNoliki;
import Converter.Converter;
import Classroom.Inovar;
import Classroom.ClassroomArray;
import Classroom.ClassroomHash;


public class Menu {
    public static Scanner Scanner = new Scanner(System.in);

    public static void MenuHeader(String title) {
		System.out.println("\n\n");
		System.out.println("────────────────────────────────────");

		System.out.println("  " + Colors.BLUE + title + Colors.RESET);

		System.out.println("────────────────────────────────────\n");
	}

	public static void MenuOption(int index, String title) {
		System.out.printf("  [%d]  %s\n", index, title);
	}


	public static void run() {

		MenuHeader("Main Menu");

		MenuOption(1, "Programs List");
		MenuOption(9, "Release Notes");
		MenuOption(0, "Exit");

		System.out.print("\n  Option: ");

		while (true) {
			int userOption = Scanner.nextInt();

			switch (userOption) {
				case 1 -> ProgramsList();
				case 9 -> ReleaseNotes();

				case 0 -> {
					System.out.println("\n  Leaved Successfully.");
					System.exit(0);
				}

				default -> Messages.Unknown();
			}
		}
	}

	public static void ProgramHeader(String title, int day, int monthvalue) { 

		String[] months = {
			"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
			"Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
		};

		String monthName = (monthvalue >= 1 && monthvalue <= 12) ? months[monthvalue - 1] : "Inválido";

		System.out.println("\n\n");
		System.out.println("────────────────────────────────────");
		System.out.println("  " + Colors.BLUE + title + Colors.RESET);
		System.out.printf("  Atualizado em %d de %s\n", day, monthName);
		System.out.println("────────────────────────────────────\n");		
	}

	public static void printProgramItem(int index, String name, String branch, String[] info) {

		System.out.printf("[%d]  %s%s%s | %s\n", index, Colors.YELLOW, name, Colors.RESET, branch);

		if (branch.equals("Beta"))
		System.out.print("     Versão em Desenvolvimento");

		System.out.println("\n     ─────────────────────────────");

		for (String line : info)
		System.out.printf("     • %s\n", line);


		System.out.println();
		System.out.println();		
	}

	public static void ProgramsList() {

		System.err.println("\n\n\n\n\n");

		printProgramItem (
			1,
			"Markulator",
			"Stable",
			new String[] {
				"Сiclo 'while' para repetir o programa",
				"Verifica o operador com 'while' e 'switch-case'",
				"Método 'ResultPrint' para imprimir o resultado formatado",
				"Verificação de divisão por zero"
			}
		);

		printProgramItem (
			2,
			"Classroom [Array]",
			"Stable",
			new String [] {
				"'ArrayList' para guardar turmas e capacidades", 
				"Impressão formatada com 'printf'",
				"Demonstração de diferentes larguras ('%-6s', '%-4s')",
				"Repetição com 'RepeatMenu'"
			}
		);

		printProgramItem (
			3,
			"Classroom [HashMap]",
			"Stable",
			new String [] {
				"HashMap para Turmas e Capacidades",
				"Validação dos Dados (1–5 turmas, 1–40 alunos)",
				"Impressão formatada em tabela",
				"Repetição com classe 'RepeatMenu'"
			}
		);

		printProgramItem (
			4, 
			"Jogo do Galo",
			"Beta",
			new String [] {
				"Matriz bidimensional 'char[][]' para o tabuleiro",
				"Métodos para mostrar o tabuleiro e verificar o vencedor",
				"Entrada de coordenadas com 'Scanner'",
			}
		);

		printProgramItem (
			5,
			"Converter",
			"Beta",
			new String [] {
				"'Map<String, Double>' para moedas e taxas",
				"'switch' para converter número em nome da moeda",
				"Cálculo e formatação do valor convertido",
				"Repetição com 'RepeatMenu'"
			}
		);

		printProgramItem (
			6,
			"Inovar",
			"Beta",
			new String [] {
				"'Map<String, Double>' para moedas e taxas",
				"'switch' para converter número em nome da moeda",
				"Cálculo e formatação do valor convertido",
				"Repetição com 'RepeatMenu'"
			}
		);

		System.out.println("\n\n  Choose the Program you want to run.\n");
		System.out.println("  [0] Menu");

		System.out.print("  Option: ");
		int userOption = Scanner.nextInt();

		while (true) {
			switch (userOption) {
				case 1 -> Markulator.run();
				case 2 -> ClassroomArray.run();
				case 3 -> ClassroomHash.run();
				case 4 -> KrestikiNoliki.run();
				case 5 -> Converter.run();
				case 6 -> Inovar.run();

				case 0 -> Menu.run();

				default -> Messages.Unknown();
			}
		}
	}



	public static void RepeatMenu(Runnable func) {

		System.out.print("\n\n  Repeat the exercise? [Y / N]: ");

		while (true) {
			char userOption = Scanner.next().charAt(0);

			switch (userOption) {
				case 'Y', 'y', 'S', 's' -> {
					func.run();
					return;
				}

				case 'N', 'n' -> {
					Menu.run();
					return;
				}
			
				default -> Messages.Unknown();
			}	
		}
	}


	public static void ReleaseBlock(String title, String[] lines) {

		System.out.println("  " + title);
		System.out.println("  ─────────────────────────────");

		for (String s : lines)
			System.out.println("  • " + s);

		System.out.println();
	}

	
	public static void ReleaseNotes() {

		ProgramHeader("Release Notes", 19, 11);

		ReleaseBlock("Added & Changed", new String[] {
				"Geral: Foi alterado o uso de 'if' e 'for' em vários casos.",
				"Inovar: O menu foi alterado.",
				"Inovar: No futuro será possível alterar e modificar disciplinas que os alunos têm.",											
			}
		);		

		ReleaseBlock("Fixed", new String[] {			
			}
		);


		ReleaseBlock("Plans", new String[] {
				"A interface será alterada em todos os programas, garantido o Design Único.",		
				"O interface terá possíbilidade de mudar a lingua.",
				"O menu prinicipal será alterado brevemente. Irá utilizar 'HashMap' e 'ArrayList' para garantir flexibilidade.",		
			}
		);


		Menu.run();
	}
}


/* 

	=============================================

	The future version of menu, using HashMap.
	Currently in Development...

	=============================================

	public static void ProgramsList() {
		HashMap<String, HashMap<String, Runnable>> branchesList = new HashMap();

		// Stable Branch
		HashMap<String, Runnable> stable = new HashMap<>();
		stable.put("Markulator", Markulator::run);
		stable.put("Converter", Converter::run);
		stable.put("Classroom [Array]", ClassroomArray::run);
		stable.put("Classroom [Hash]", ClassroomHash::run);

		// Beta Branch
		HashMap<String, Runnable> beta = new HashMap<>();
		beta.put("Jogo do Galo", KrestikiNoliki::run);
		beta.put("Inovar", Inovar::run);

		// Branches Addition 
		branchesList.put("Stable", stable);
		branchesList.put("Beta", beta);

		System.out.println("\n\n\n");

		int index = 1;

		for (String stablePrograms : stable.keySet()) {
			System.out.printf("[%d] Stable | %s\n", index, stablePrograms);
			index++;
		}

		System.out.println();
		
		for (String betaPrograms : beta.keySet()) {
			System.out.printf("[%d] Beta | %s\n", index, betaPrograms);	
			index++;
		}
	}

	*/