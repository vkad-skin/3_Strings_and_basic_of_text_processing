package by.epam.strings_and_basics_of_text_processing.string_as_object;

import java.util.Scanner;

/*
 * Задание 7: В Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde 
 * def", то должно быть выведено "abcdef". 
 */

public class Task7 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Полученный текст >>"
				+ deleteDuplicateCharacters(inputText()));
	}

	private static String inputText() {

		System.out.print("Введите текст >>");

		String text;
		text = scan.nextLine();
		scan.close();

		return text;
	}

	private static String deleteDuplicateCharacters(String text) {

		text = text.trim();

		StringBuilder newText = new StringBuilder(text);

		char symbol;

		for (int indexCharacter = 0; indexCharacter < newText.length(); indexCharacter++) {

			symbol = newText.charAt(indexCharacter);

			for (int indexDeleteCharacter = indexCharacter + 1; indexDeleteCharacter < newText
					.length(); indexDeleteCharacter++) {

				if (newText.charAt(indexDeleteCharacter) == symbol
						|| newText.charAt(indexDeleteCharacter) == ' ') {

					newText.deleteCharAt(indexDeleteCharacter);
					indexDeleteCharacter--;
				}
			}
		}
		return newText.toString();
	}
}
