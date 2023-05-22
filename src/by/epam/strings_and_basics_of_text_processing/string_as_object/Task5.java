package by.epam.strings_and_basics_of_text_processing.string_as_object;

/*
 * Задание 5: Подсчитать, сколько раз среди символов заданной строки встречается буква “а”..
 */

public class Task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text;

		text = "Возвращает индекс в этой строке первого вхождения указанной подстроки, начиная с указанного индекса.";

		System.out.println("Количество символов  >>" + countSymbol(text));
	}

	public static int countSymbol(String text) {

		int countA;
		int indexSubstring;
		int indexString;
		
		indexString = 0;
		countA = 0;

		while (indexString < text.length()) {

			indexSubstring = text.indexOf("а", indexString);
			
			if (indexSubstring >= 0) {
				indexString = indexSubstring + 1;
				indexSubstring = 0;
				countA++;
			
			} else if (indexSubstring == -1){
				indexString = text.length();
			}
			
		}
		
		return countA;
	}
}
