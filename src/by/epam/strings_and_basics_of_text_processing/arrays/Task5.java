package by.epam.strings_and_basics_of_text_processing.arrays;

/*
 * Задание 5: Удалить в  строке  все  лишние  пробелы,  то  есть  серии  подряд  идущих  пробелов  заменить на  одиночные  пробелы. 
 * Крайние пробелы в строке удалить.
 */

public class Task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text;

		text = "  qwe    erttt rrrr    tlfgkdf   w222       ";

		System.out.println("Текст с удалением лишних пробелов >>" + deleteSpacesInString(text));
	}

	public static String deleteSpacesInString(String text) {

		char[] oldTextArray;
		char[] newTextArray;
		int indexOldArray;

		indexOldArray = 0;

		oldTextArray = text.toCharArray();
		newTextArray = new char[lenghtStringWithoutSpaces(oldTextArray)];

		for (int indexNewArray = 0; indexNewArray < newTextArray.length; indexNewArray++) {

			while (indexOldArray < oldTextArray.length) {

				if ((Character.isWhitespace(oldTextArray[indexOldArray])) && (indexOldArray == 0)) {

					indexOldArray++;

				} else if (!Character.isWhitespace(oldTextArray[indexOldArray])) {

					newTextArray[indexNewArray] = oldTextArray[indexOldArray];
					indexOldArray++;
					break;

				} else if ((!Character.isWhitespace(oldTextArray[indexOldArray - 1]))
						&& (Character.isWhitespace(oldTextArray[indexOldArray]))) {

					newTextArray[indexNewArray] = oldTextArray[indexOldArray];
					indexOldArray++;
					break;
				}
				indexOldArray++;
			}
		}

		text = String.valueOf(newTextArray);

		return text;
	}

	public static int lenghtStringWithoutSpaces(char[] oldTextArray) {

		int countLenght;

		countLenght = 0;

		for (int indexOldArray = 0; indexOldArray < oldTextArray.length; indexOldArray++) {

			if ((Character.isWhitespace(oldTextArray[indexOldArray])) && (indexOldArray == 0)) {
				countLenght += 0;

			} else if (!Character.isWhitespace(oldTextArray[indexOldArray])) {
				countLenght++;

			} else if ((Character.isWhitespace(oldTextArray[indexOldArray]))
					&& (indexOldArray == oldTextArray.length - 1)) {
				countLenght += 0;

			} else if ((!Character.isWhitespace(oldTextArray[indexOldArray - 1]))
					&& (Character.isWhitespace(oldTextArray[indexOldArray]))) {
				countLenght++;
			}
		}

		if (Character.isWhitespace(oldTextArray[oldTextArray.length - 1])
				&& Character.isWhitespace(oldTextArray[oldTextArray.length - 2])) {
			countLenght--;
		}

		return countLenght;
	}
}
