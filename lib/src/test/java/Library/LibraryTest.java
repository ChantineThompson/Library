package Library;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class LibraryTest {
	Library test = new Library();
	File file = new File("test.txt");

	@Test
	public void testWordCount() {
		try {
			assertTrue("Word count should be 37", test.wordCount(file)==37);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
	}

	@Test
	public void testLineCount() {
		try {
			assertTrue("Line count should be 3", test.lineCount(file)==3);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
	}

	@Test
	public void testAverageLetters() {
		try {
			assertTrue("Average letters should be 5.5 rounded", test.averageLetters(file)==5.5);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
	}
	
	@Test
	public void testMostUsedLetter() {
		try {
			assertTrue("Most used letter should be e", test.commonLetter(file)=='e');
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
	}

}

