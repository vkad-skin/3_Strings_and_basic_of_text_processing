package by.epam.strings_and_basics_of_text_processing.arrays;

/*
 * Задание 2: Замените в строке все вхождения 'word' на 'letter'.
 */

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stud

		String text;
		char[] arrayWord;
		char[] arrayLetter;

		text = "asd d worddorword word w o r d wor4dwordwordordw word";
		arrayWord = text.toCharArray();

		arrayLetter = new char[arrayWord.length + (wordLenght(arrayWord) * 2)];

		text = new String(substitutionWord(arrayLetter, arrayWord));
		System.out.println(text);
	}

	public static int wordLenght(char[] arrayWord) {

		int lenght;

		lenght = 0;

		for (int indexArrayWord = 0; indexArrayWord < arrayWord.length - 3; indexArrayWord++) {

			if (arrayWord[indexArrayWord] == 'w'
					&& arrayWord[indexArrayWord + 1] == 'o'
					&& arrayWord[indexArrayWord + 2] == 'r'
					&& arrayWord[indexArrayWord + 3] == 'd') {
				lenght++;
			}
		}

		return lenght;
	}

	public static char[] substitutionWord(char[] arrayLetter, char[] arrayWord) {

		int indexArrayWord;

		indexArrayWord = 0;

		for (int indexArrayLetter = 0; indexArrayLetter < arrayLetter.length - 5; indexArrayLetter++, indexArrayWord++) {

			if (arrayWord[indexArrayWord] == 'w'
					&& arrayWord[indexArrayWord + 1] == 'o'
					&& arrayWord[indexArrayWord + 2] == 'r'
					&& arrayWord[indexArrayWord + 3] == 'd') {

				arrayLetter[indexArrayLetter] = 'l';
				arrayLetter[indexArrayLetter + 1] = 'a';
				arrayLetter[indexArrayLetter + 2] = 't';
				arrayLetter[indexArrayLetter + 3] = 't';
				arrayLetter[indexArrayLetter + 4] = 'e';
				arrayLetter[indexArrayLetter + 5] = 'r';

				indexArrayLetter = indexArrayLetter + 5;
				indexArrayWord = indexArrayWord + 3;

			} else {
				arrayLetter[indexArrayLetter] = arrayWord[indexArrayWord];
			}
		}
		return arrayLetter;
	}
}
