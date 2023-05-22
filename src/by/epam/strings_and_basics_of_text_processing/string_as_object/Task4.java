package by.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 * Задание 4: С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 */

public class Task4 {

	public static void main(String[] args) {

		String informatics;

		informatics = "информатика";

		System.out.println("Слово получилось >>" + wordСhange(informatics));
	}

	public static String wordСhange(String informatics) {

		String cake;

		cake = "";

		if (informatics.contains("т") && informatics.contains("о") && informatics.contains("р")) {

			cake = cake.concat(String.copyValueOf(informatics.toCharArray(), informatics.indexOf('т'), 1));
			cake = cake.concat(String.copyValueOf(informatics.toCharArray(), informatics.indexOf('о'), 1));
			cake = cake.concat(String.copyValueOf(informatics.toCharArray(), informatics.indexOf('р'), 1));
			cake = cake.concat(String.copyValueOf(informatics.toCharArray(), informatics.indexOf('т'), 1));
		}

		return cake;
	}
}
