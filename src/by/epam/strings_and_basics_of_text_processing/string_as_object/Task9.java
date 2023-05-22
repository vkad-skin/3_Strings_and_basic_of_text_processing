package by.epam.strings_and_basics_of_text_processing.string_as_object;

import java.util.Scanner;

/*
 * Задание 9: Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские 
 * буквы.
 */

public class Task9 {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] count;

		count = countLowerAndUpperCase(inputText());
		System.out.println("Количество прописных букв >>" + count[0]
				+ "\nКоличество строчных букв >>" + count[1]);
	}

	public static String inputText() {

		System.out.print("Введите текст >>");

		String text;
		text = scan.nextLine();

		return text;
	}

	public static int[] countLowerAndUpperCase(String text) {

		int[] countArrayCase;

		countArrayCase = new int[2];

		for (int indexText = 0; indexText < text.length(); indexText++) {

			if ((text.codePointAt(indexText) >= "a".codePointAt(0))
					&& (text.codePointAt(indexText) <= "z".codePointAt(0))) {
				countArrayCase[0]++;

			} else if ((text.codePointAt(indexText) >= "A".codePointAt(0))
					&& (text.codePointAt(indexText) <= "Z".codePointAt(0))) {
				countArrayCase[1]++;
			}
		}
		return countArrayCase;
	}
}
