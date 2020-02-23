import java.util.Hashtable;

public class WordList {
	
	private Hashtable<String, Word> words;
	private InputCleaner sanitizer;
	
	public WordList()
	{
		words = new Hashtable<>();
		sanitizer = new InputCleaner();
	}
	
	/**
	 *  Purpose: add a word to the collection of words
	 *  @param word: word to be added
	 *  Output: none
	 *  Assumptions: word is not currently in words
	 */
	public void addWord(String word, String before, String after)
	{
		Word w = new Word(word, before, after);
		words.put(word, w);
	}
	
	/**
	 *  Purpose: handle a String of input
	 *  @param input: input from user
	 *  Output: none
	 *  Assumptions: none
	 */
	public void readInput(String input)
	{
		String[] wordsToAdd = input.split(" ");
		wordsToAdd = sanitize(wordsToAdd);
		
		for (int i = 0; i < wordsToAdd.length; i++)
		{
			String word, before, after;
			word = wordsToAdd[i];
			
			if (i == 0)
			{
				before = "<start>";
				after = wordsToAdd[i + 1];
			}
			else if (i - 1 == wordsToAdd.length)
			{
				before = wordsToAdd[i - 1];
				after = "<finish>";
			}
			else
			{
				before = wordsToAdd[i - 1];
				after = wordsToAdd[i + 1];
			}
			
			if (words.containsKey(word))
			{
				Word w = words.get(word);
				w.updateWord(before, after);
			}
			else
			{
				addWord(word, before, after);
			}
		}
	}
	
	/**
	 *  Purpose: sanitize the input from user (prevents special characters, capitalized versions of duplicate words
	 *  @param input: the array of Strings to be sanitized
	 *  @return cleanInput: the sanitized input
	 *  Assumptions: none
	 */
	private String[] sanitize(String[] input)
	{
		String[] cleanInput = input;
		
		for (String s : cleanInput)
		{
			sanitizer.cleanWord(s);
		}
		
		return cleanInput;
	}
	
	/**
	 *  Purpose: return list of words
	 *  Input: none
	 *  @return words: the list of words being maintained by this WordList
	 *  Assumptions: none
	 */
	public Hashtable<String, Word> getWordList()
	{
		return words;
	}
}