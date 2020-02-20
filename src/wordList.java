import java.util.Hashtable;

public class wordList {
	
	private Hashtable<String, Word> words;
	
	public wordList()
	{
		words = new Hashtable<>();
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
	public void handleInput(String input)
	{
		String[] wordsToAdd = input.split(" ");
		
		for (int i = 0; i < wordsToAdd.length; i++)
		{
			String word, before, after;
			word = wordsToAdd[i];
			
			if (i == 0)
			{
				before = null;
				after = wordsToAdd[i + 1];
			}
			else if (i - 1 == wordsToAdd.length)
			{
				before = wordsToAdd[i - 1];
				after = null;
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