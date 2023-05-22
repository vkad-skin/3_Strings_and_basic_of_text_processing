package by.epam.strings_and_basics_of_text_processing.string_as_object;

import java.util.Scanner;

/*
 * Задание 10: Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным 
 * знаком. Определить количество предложений в строке X.
 */

public class Task10 {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text;

		text = inputText();

		System.out
				.println("Количество предложений >>" + numberOfSentence(text));
	}

	public static String inputText() {

		System.out.print("Введите текст >>");

		String text;
		text = scan.nextLine();

		return text;
	}

	public static int numberOfSentence(String text) {

		int countSentence;

		countSentence = 0;

		for (int indexText = 0; indexText < text.length(); indexText++) {

			if (text.codePointAt(indexText) == '.'
					|| text.codePointAt(indexText) == '!'
					|| text.codePointAt(indexText) == '?') {

				countSentence++;
			}
		}

		return countSentence;
	}
}
