import java.util.Scanner;
import java.util.regex.*;

public class InputCleaner {
	
	Pattern alphaNumOnly;
	
	public InputCleaner()
	{
		alphaNumOnly = Pattern.compile("[^a-zA-Z0-9]");
	}
	
	public String cleanWord(String word)
	{
		String cleanWord = word;
		cleanWord = removeSpecChars(cleanWord);
		cleanWord = cleanWord.toLowerCase();
		
		return cleanWord;
	}
	
	/**
	 *  Purpose: remove special characters from a string so only alphanumeric characters remain
	 *  @param input: the word to be fixed
	 *  @return s: the fixed word
	 *  Assumptions: none
	 *  adapted from solution at https://stackoverflow.com/questions/14361556/remove-all-special-characters-in-java/14361667
	 */
	private String removeSpecChars(String input)
	{
		String cleanWord = input;
		Matcher match = alphaNumOnly.matcher(cleanWord);
		while (match.find())
		{
			String s = match.group();
			cleanWord = cleanWord.replaceAll("\\" + s, "");
		}
		
		return input;
	}	
}