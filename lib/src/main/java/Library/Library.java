package Library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * 
 * @author Chantine Thompson
 * This class implements a library that takes in a text file, and calculates the number of words,
 * average number of letters, number of lines and the most common letter. An all stats method is 
 * also used to return the results of all the methods in one string.
 *
 */

public class Library{
	/**
	 * 
	 * @param file Takes in the file selected in main
	 * @return wordCount The number of words in the text file
	 * @throws IOException If the file doesn't exist
	 */
	public int wordCount(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String line; 
		int wordCount = 0;

		while((line = br.readLine()) != null){ 
			String[] wordList = line.split("\\s+"); 
			wordCount += wordList.length; 
		} 
		br.close();
		return wordCount;
	}

	/**
	 * 
	 * @param file Takes in the file selected in main
	 * @return lineCount The number of lines in the file
	 * @throws IOException If the file doesn't exist
	 */
	public int lineCount(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		int lineCount = 0;
		while (br.readLine() != null) {
			lineCount++;
		}
		br.close();
		return lineCount;
	}

	/**
	 * 
	 * @param file Takes in the file selected in main
	 * @return letterAverage The average number of letters per word
	 * @throws IOException If the file doesn't exist
	 */
	public double averageLetters(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		double letterCount = 0;
		String content =  br.lines().collect(Collectors.joining());

		content = content.replaceAll("[^a-zA-Z]", "");
		letterCount = content.length();
		br.close();

		double letterAverage = letterCount / wordCount(file);
		return letterAverage = Math.round(letterAverage * 10.0) / 10.0;
	}

	/**
	 * 
	 * @param file Takes in the file selected in main
	 * @return maxChar The most used character in the text file
	 * @throws IOException If the file doesn't exist
	 */
	public char commonLetter(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String content =  br.lines().collect(Collectors.joining());
		int counter = 0;
		int countArray[] = new int[256]; 
		char maxChar = ' ';

		content = content.replaceAll("[^a-zA-Z0-9]", "");

		for (int i = 0; i < content.length(); i++){
			char c = content.charAt(i);

			countArray[c]++;
			if (countArray[c] >= counter){
				counter = countArray[c];
				maxChar = c;
			}
		}
		br.close();
		return maxChar;
	}
	
	/**
	 * 
	 * @param file Takes in the file selected in main
	 * @return stats All of the statistics in one string
	 * @throws IOException If the file doesn't exist
	 */
	public String allStats(File file) throws IOException {
		System.out.println("The stats from this text file:");
		String stats = ("Word Count: " + wordCount(file) + "\nLine Count: " + lineCount(file)
		+ "\nAverage letters per word: " + averageLetters(file) + "\nMost common letter: " + commonLetter(file));
		
		return stats;
	}
}