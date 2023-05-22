package by.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 * Задание 3: Проверить, является ли заданное слово палиндромом.
 */

public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text;

		text = "Rever";

		System.out.println("Слово " + text + " является палиндромом? >>" + isPalindromeWord(text));
	}

	public static boolean isPalindromeWord(String text) {

		StringBuilder textReverse = new StringBuilder(text);

		textReverse.reverse();

		return text.equalsIgnoreCase(textReverse.toString());

	}

}
