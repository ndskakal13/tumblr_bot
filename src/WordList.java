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
	 *  Assumptions: input is not 1 token long
	 *  TODO: allow to handle 1 token long Strings
	 */
	public void readInput(String input)
	{
		String[] wordsToAdd = input.split(" ");
		wordsToAdd = sanitize(wordsToAdd);
		String word = "", before = "", after = "";
		
		if (wordsToAdd.length == 1)
		{
			word = wordsToAdd[0];
			before = "<start>";
			after = "<finish>";
		}
		else
		{
			for (int i = 0; i < wordsToAdd.length; i++)
			{
				
				word = wordsToAdd[i];
				
				if (i == 0)
				{
					before = "<start>";
					after = wordsToAdd[i + 1];
				}
				else if (i + 1 == wordsToAdd.length)
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
		
		for (int i = 0; i < cleanInput.length; i++)
		{
			cleanInput[i] = sanitizer.cleanWord(cleanInput[i]);
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