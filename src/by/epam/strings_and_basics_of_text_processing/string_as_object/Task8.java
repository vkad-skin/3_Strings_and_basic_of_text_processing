package by.epam.strings_and_basics_of_text_processing.string_as_object;

import java.util.Scanner;

/*
 * Задание 8: Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых 
 * длинных слов может быть несколько, не обрабатывать.
 */

public class Task8 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		String text;

		text = inputText();

		System.out.println("Самое длинное слово >>" + longestWordNew(text));
	}

	public static String inputText() {

		System.out.print("Введите текст >>");

		String text;
		text = scan.nextLine();

		return text;
	}

	public static String longestWordNew(String text) {

		String[] mas;
		String maxLongWord;

		maxLongWord = null;

		text = text.trim().replaceAll("( )+", " ");
		mas = text.split(" ");

		for (int indexText = 0; indexText < mas.length; indexText++) {

			if (maxLongWord == null) {
				maxLongWord = mas[indexText].substring(0);

			} else if (mas[indexText].length() > maxLongWord.length()) {
				maxLongWord = mas[indexText].substring(0);
			}
		}
		return maxLongWord;
	}

	public static String longestWordOld(String text) {

		String word;
		String maxLongWord;

		int indexStart;
		int indexEnd;
		int count;

		text = text.trim();

		maxLongWord = null;

		count = 0;
		indexStart = -1;
		indexEnd = -1;

		for (int indexText = 0; indexText < text.length(); indexText++) {

			if ((text.charAt(indexText) != ' ') && (count == 0)) {
				indexStart = indexText;
				count = 1;

			} else if ((text.charAt(indexText) == ' ')
					&& (text.charAt(indexText - 1) != ' ')) {

				indexEnd = indexText;
				count = 0;

			} else if (indexText == text.length() - 1) {
				indexEnd = indexText + 1;
				count = 0;
			}

			if (indexStart > -1 && indexEnd > -1) {

				word = text.substring(indexStart, indexEnd);

				if (maxLongWord == null) {
					maxLongWord = word;

				} else if (word.length() > maxLongWord.length()) {
					maxLongWord = word;
				}

				indexStart = -1;
				indexEnd = -1;
			}
		}
		return maxLongWord;
	}
}