package by.epam.strings_and_basics_of_text_processing.regex;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "Такой чистосердечный подход, я полагаю, еще более приблизит к нам образ великого поэта.\n"
				+ "Итак, сто лет отделяют нас от него! Время действительно бежит неслыханно быстро!.\n"
				+ "Германская война, как известно, началась двадцать три года назад. То есть, когда она началась, то до Пушкина было не сто лет, а всего семьдесят семь.\n"
				+ "А я родился, представьте себе, в 1879 году. Стало быть, был еще ближе к великому поэту. Не то чтобы я мог его видеть, но, как говорится, нас отделяло всего около сорока лет.\n"
				+ "Моя же бабушка, еще того чище, родилась в 1836 году. То есть Пушкин мог ее видеть и даже брать на руки. Он мог ее нянчить, и она могла, чего доброго, плакать на руках, не предполагая, кто ее взял на ручки.\n"
				+ "Конечно, вряд ли Пушкин мог ее нянчить, тем более что она жила в Калуге, а Пушкин, кажется, там не бывал, но все-таки можно допустить эту волнующую возможность, тем более что он мог бы, кажется, заехать в Калугу повидать своих знакомых.";

		print(sortParagraph(text) + "\n");
		print(sortWords(text) + "\n");
		print(sortToken(text, 'а'));

	}

	public static String sortParagraph(String text) {

		String[] paragraph;

		paragraph = getParagraph(text);

		paragraph = sortShellParagraph(paragraph);

		return setText(paragraph);
	}

	public static String sortWords(String text) {

		String[] paragraphs;
		String[] sentences;
		String[] words;

		paragraphs = getParagraph(text);

		for (int index = 0; index < paragraphs.length; index++) {

			sentences = getSentence(paragraphs[index]);

			for (int i = 0; i < sentences.length; i++) {

				words = getWord(sentences[i]);
				words = sortShellWord(words);
				sentences[i] = setSentence(words);
			}

			paragraphs[index] = setParagraph(sentences);
		}
		return setText(paragraphs);
	}

	public static String sortToken(String text, char token) {

		String[] paragraphs;
		String[] sentences;
		String[] words;

		paragraphs = getParagraph(text);

		for (int index = 0; index < paragraphs.length; index++) {

			sentences = getSentence(paragraphs[index]);

			for (int i = 0; i < sentences.length; i++) {

				words = getWord(sentences[i]);

				words = sortShellTokenInWord(words, token);
				sentences[i] = setSentence(words);
			}

			paragraphs[index] = setParagraph(sentences);
		}

		return setText(paragraphs);

	}

	private static String[] sortShellParagraph(String[] text) {

		/*
		 * Сортировка Шелла.
		 */

		String textContainer;

		int indexText;

		indexText = 0;

		while (true) {

			if (numberOfSentence(text[indexText]) > numberOfSentence(text[indexText + 1])) {

				textContainer = text[indexText];
				text[indexText] = text[indexText + 1];
				text[indexText + 1] = textContainer;
				indexText--;

			} else if (numberOfSentence(text[indexText]) <= numberOfSentence(text[indexText + 1])) {
				indexText++;
			}
			
			if (indexText < 0) {
				indexText = 0;
			}

			if (indexText == text.length - 1) {
				break;
			}
		}

		return text;
	}

	private static String[] sortShellWord(String[] words) {

		String textContainer;

		int indexWord;

		indexWord = 0;

		while (true) {

			if (words[indexWord].length() > words[indexWord + 1].length()) {

				textContainer = words[indexWord];
				words[indexWord] = words[indexWord + 1];
				words[indexWord + 1] = textContainer;
				indexWord--;

			} else if (words[indexWord].length() <= words[indexWord + 1].length()) {
				indexWord++;
			}

			if (indexWord < 0) {
				indexWord = 0;
			}

			if (indexWord == words.length - 1) {
				break;
			}
		}

		return words;
	}

	private static String[] sortShellTokenInWord(String[] words, char token) {

		String textContainer;

		int indexWord;

		indexWord = 0;

		while (true) {

			if (numberOfTokenInAWord(words[indexWord], token) > numberOfTokenInAWord(words[indexWord + 1], token)) {

				textContainer = words[indexWord];
				words[indexWord] = words[indexWord + 1];
				words[indexWord + 1] = textContainer;
				indexWord--;

			} else if (numberOfTokenInAWord(words[indexWord], token) < numberOfTokenInAWord(words[indexWord + 1],
					token)) {
				indexWord++;

			} else {

				if (words[indexWord].charAt(0) < words[indexWord + 1].charAt(0)) {

					textContainer = words[indexWord];
					words[indexWord] = words[indexWord + 1];
					words[indexWord + 1] = textContainer;
					indexWord--;

				} else {
					indexWord++;
				}

			}

			if (indexWord < 0) {
				indexWord = 0;
			}

			if (indexWord == words.length - 1) {
				break;
			}
		}

		return words;
	}

	private static int numberOfSentence(String text) {

		int countSentence;

		countSentence = 0;

		for (int indexText = 0; indexText < text.length(); indexText++) {

			if (text.codePointAt(indexText) == '.' 
					|| text.codePointAt(indexText) == '!'
					|| text.codePointAt(indexText) == '?') {

				countSentence++;
			}
		}

		return countSentence;
	}

	private static int numberOfTokenInAWord(String word, char token) {

		int countToken;

		countToken = 0;

		for (int indexWord = 0; indexWord < word.length(); indexWord++) {

			if (word.charAt(indexWord) == token || word.charAt(indexWord) == Character.toUpperCase(token)) {
				countToken++;
			}
		}

		return countToken;
	}

	private static String[] getParagraph(String text) {
		return text.split("\n");
	}

	private static String[] getSentence(String text) {
		return text.split("\\.\\s|!\\s|\\?\\s|\\.|!|\\?");
	}

	private static String[] getWord(String text) {
		return text.split("\\s*(\\s|!|\\.)\\s*");
	}

	private static String setText(String[] paragraph) {

		if (paragraph.equals(null)) {
			return "";
		}

		String text = "";

		for (int index = 0; index < paragraph.length; index++) {

			if (index == paragraph.length - 1) {
				text += paragraph[index];

			} else {
				text += paragraph[index] + "\n";
			}
		}
		return text;
	}

	private static String setParagraph(String[] sentences) {

		if (sentences.equals(null)) {
			return "";
		}

		String paragraph = "";

		for (int indexSentence = 0; indexSentence < sentences.length; indexSentence++) {

			if (indexSentence == sentences.length - 1) {
				paragraph += sentences[indexSentence];

			} else {
				paragraph += sentences[indexSentence] + " ";
			}
		}
		return paragraph;
	}

	private static String setSentence(String[] words) {

		if (words.equals(null)) {
			return "";
		}

		String sentence = "";

		for (int indexWord = 0; indexWord < words.length; indexWord++) {

			if (indexWord == words.length - 1) {
				sentence += words[indexWord] + ".";

			} else {
				sentence += words[indexWord] + " ";
			}
		}
		return sentence;
	}

	public static void print(String text) {
		System.out.println(text);

	}
}
