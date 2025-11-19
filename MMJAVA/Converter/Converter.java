package Converter;


import Interface.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Converter {

    public static Scanner Scanner = new Scanner(System.in);

	public static void printSection(String title) {
		System.out.println("\n");
		System.out.println("  " + title);
		System.out.println("  ─────────────────────────────");
	}

    public static String ConverterSwitch(int Option) {
		return switch (Option) {
			case 1 -> "Dollar";
			case 2 -> "Euro";
			case 3 -> "Yen";
			case 4 -> "Pound";
			case 5 -> "Franc";
			case 6 -> "Tenge";
			case 7 -> "Ruble";
			default -> "";
		};
	}

	public static void showCurrencies() {

		printSection("Moedas Disponíveis");

		System.out.println("  [1]  [$] Dollar");
		System.out.println("  [2]  [€] Euro");
		System.out.println("  [3]  [¥] Yen");
		System.out.println("  [4]  [£] Pound");
		System.out.println("  [5]  [₣] Franc");
		System.out.println("  [6]  [₸] Tenge");
		System.out.println("  [7]  [₽] Ruble");

		System.out.println();
	}


	public static void run() {

		Menu.ProgramHeader("Converter", 19, 11);

		Map<String, Double> currencyMap = new HashMap<>();
		currencyMap.put("Dollar", 1.0);
		currencyMap.put("Euro", 0.93);
		currencyMap.put("Tenge", 485.0);
		currencyMap.put("Yen", 150.0);
		currencyMap.put("Pound", 0.79);
		currencyMap.put("Franc", 0.89);
		currencyMap.put("Ruble", 98.5);

		showCurrencies();

		int inputCurrencyValue;
		String inputCurrency;

		do {
			System.out.print("  From: ");
			inputCurrencyValue = Scanner.nextInt();
			inputCurrency = ConverterSwitch(inputCurrencyValue);

			if (inputCurrencyValue < 1 || inputCurrencyValue > currencyMap.size()) {
				System.out.println("  Incorrect Option");
			}

		} while (inputCurrencyValue < 1 || inputCurrencyValue > currencyMap.size());

		System.out.printf("\n  Escolhido: %s\n", inputCurrency);

		System.out.print("  Ammount: ");
		int userAmount = Scanner.nextInt();

		showCurrencies();

		int outputCurrencyValue;
		String outputCurrency;

		do {
			System.out.printf("\n  %d %s → ", userAmount, inputCurrency);
			outputCurrencyValue = Scanner.nextInt();
			outputCurrency = ConverterSwitch(outputCurrencyValue);

			if (outputCurrencyValue < 1 || outputCurrencyValue > currencyMap.size() || outputCurrencyValue == inputCurrencyValue) {
				System.out.println("  Incorrect Option");
			}

		} while (outputCurrencyValue < 1 || outputCurrencyValue > currencyMap.size() || outputCurrencyValue == inputCurrencyValue);

		double inputRate = currencyMap.get(inputCurrency);
		double outputRate = currencyMap.get(outputCurrency);
		double result = userAmount * (inputRate / outputRate);

		printSection("Resultado");

		System.out.printf("  %d %s = %.2f %s\n", userAmount, inputCurrency, result, outputCurrency);

		Menu.RepeatMenu(() -> run());
	}
}
