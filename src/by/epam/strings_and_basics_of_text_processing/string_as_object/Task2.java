package by.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 * Задание 2: В строке вставить после каждого символа 'a' символ 'b'.
 */

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text;

		text = "sadagabf saabas gafa";

		System.out.println("Cтрока с добавлением после символа 'a' символ 'b' >>" + addSymbolB(text));
	}

	public static String addSymbolB(String text) {

		StringBuilder textBuilder = new StringBuilder(text);

		for (int i = 0; i < textBuilder.length() ; i++) {
			
			if (textBuilder.charAt(i) == 'a') {
				textBuilder.insert(i + 1, 'b');
			}
		}

		return textBuilder.toString();
	}




}
