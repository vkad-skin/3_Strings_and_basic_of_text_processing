package by.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 * Задание 6: Из заданной строки получить новую, повторив каждый символ дважды. 
 */

public class Task6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text;

		text = " sd sertg";

		System.out.println(duplicationCharacter(text).replaceAll(" ", ""));
	}

	public static String duplicationCharacter(String text) {

		StringBuilder originalText = new StringBuilder(text);
		StringBuilder duplicationCharacterText = new StringBuilder();

		for (int indexOriginalText = 0; indexOriginalText < originalText
				.length(); indexOriginalText++) {

			for (int indexDuplication = 0; indexDuplication < 3; indexDuplication++) {
				duplicationCharacterText.append(originalText
						.charAt(indexOriginalText));
			}

		}

		return duplicationCharacterText.toString();
	}
}
