import java.util.Hashtable;

public class Word {
	
	public Hashtable<String, Integer> wordsBefore, wordsAfter;
	private final String word;
	
	// constructor for a new Word
	public Word(String w, String before, String after)
	{
		this.word = w;
		wordsBefore = new Hashtable<>();
		wordsAfter = new Hashtable<>();
		
		wordsBefore.put(before, 1);
		wordsAfter.put(after, 1);
	}
	
	/***
	 *  Purpose: update a Word's before and after tables
	 *  @param before: word that came before, or null
	 *  @param after: word that came after, or null
	 *  Output: none
	 *  Assumptions: Word object already exists
	 */
	public void updateWord(String before, String after)
	{
		try
		{
			Integer befVal = wordsBefore.get(before) + 1;
			wordsBefore.replace(before, befVal);
		}
		catch (NullPointerException ex)
		{
			Integer befVal = 1;
			wordsBefore.put(before, befVal);
		}
		
		try
		{
			Integer aftVal = wordsAfter.get(after) + 1;
			wordsAfter.replace(after, aftVal);
		}
		catch (NullPointerException ex)
		{
			Integer aftVal = 1;
			wordsAfter.put(after, aftVal);
		}
		
	}
	
	/**
	 *  Purpose: get the String version of this Word
	 *  @return word: this Word as a String
	 */
	public String getWord()
	{
		return word;
	}
}