package by.epam.strings_and_basics_of_text_processing.arrays;

/*
 *  Задание 1: Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text;

		text = "asdRebcamelCaseSnakeCaseEuropAme";

		System.out.println("Получившийся текст: " + createSnakeCase(text));
	}

	public static String createSnakeCase(String text) {

		if (text.isEmpty()) {
			return null;
		}

		char[] camelCase;
		char[] snakeCase;

		int countCamelCase;

		countCamelCase = 0;

		camelCase = text.toCharArray();
		snakeCase = new char[snakeCaseLenght(camelCase)];

		for (int countSnakeCase = 0; countSnakeCase < snakeCase.length; countSnakeCase++, countCamelCase++) {

			if (Character.isUpperCase(camelCase[countCamelCase])) {
				snakeCase[countSnakeCase] = '_';
				snakeCase[countSnakeCase + 1] = Character.toLowerCase(camelCase[countCamelCase]);
				countSnakeCase++;

			} else {
				snakeCase[countSnakeCase] = camelCase[countCamelCase];
			}

		}

		text = new String(snakeCase);

		return text;
	}

	public static int snakeCaseLenght(char[] camelCase) {

		int countLenght;

		countLenght = 0;

		for (int countCamelCase = 0; countCamelCase < camelCase.length; countCamelCase++) {

			if (Character.isUpperCase(camelCase[countCamelCase])) {
				countLenght++;
			}
		}

		countLenght += camelCase.length;

		return countLenght;
	}
}
