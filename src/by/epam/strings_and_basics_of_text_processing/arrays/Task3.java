package by.epam.strings_and_basics_of_text_processing.arrays;

/*
 * Задание 3: В строке найти количество цифр.
 */

public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text;

		text = "asd 0120003d w003or43ddorw45545ord78 word 01 w o r d wor 4dwordwordordw wo3rd6";

		System.out.println("Количество цифр в тексте >>" + numberOfDigitInString(text));
	}

	public static int numberOfDigitInString(String text) {

		char[] textArray;
		int[] dataArray;
		int countDigit;

		textArray = text.toCharArray();
		countDigit = 0;

		for (int indexTextArray = 0; indexTextArray < textArray.length; indexTextArray++) {

			dataArray = isDigitInString(textArray, indexTextArray);

			if (dataArray[0] == 1) {
				indexTextArray = dataArray[1];
				countDigit++;

			} else {
				indexTextArray = dataArray[1];
			}

		}
		return countDigit;
	}

	public static int[] isDigitInString(char[] textArray, int indexTextArray) {

		int countDigit;
		int[] dataArray;

		countDigit = 0;
		dataArray = new int[2];

		while (Character.isDigit(textArray[indexTextArray])) {

			if (textArray[indexTextArray] == '0' && countDigit == 0) {
				break;
			}

			if (textArray.length - 1 > indexTextArray) {
				indexTextArray++;
				countDigit++;

			} else if (textArray.length - 1 == indexTextArray) {
				countDigit++;
				break;
			}
		}

		if (countDigit == 1) {
			dataArray[0] = 1;
			dataArray[1] = indexTextArray;

			return dataArray;

		} else {
			dataArray[0] = 0;
			dataArray[1] = indexTextArray;

			return dataArray;
		}
	}
}