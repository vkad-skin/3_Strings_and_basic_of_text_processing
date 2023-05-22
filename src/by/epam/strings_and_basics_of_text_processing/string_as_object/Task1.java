package by.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 * Задание 1: Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text;

		text = " qwe     we  qwr   2222 ";

		System.out.println("Максимальное количество пробелов подряд >>" + maxNumberOfSpaces(text));
	}

	public static int maxNumberOfSpaces(String text) {

		StringBuilder textBuilder = new StringBuilder(text);

		int countSpaces;
		int maxCountSpaces;

		countSpaces = 0;
		maxCountSpaces = 0;

		for (int indexSymbol = 0; indexSymbol < textBuilder.length(); indexSymbol++) {

			if (textBuilder.charAt(indexSymbol) == ' ') {
				countSpaces++;

			} else if (countSpaces != 0) {
				maxCountSpaces = maxCountSpaces < countSpaces ? countSpaces : maxCountSpaces;
				countSpaces = 0;
			}
		}

		return maxCountSpaces;
	}
}
