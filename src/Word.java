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
		Integer newVal = wordsBefore.get(before) + 1;
		wordsBefore.replace(before, newVal);
		
		newVal = wordsAfter.get(after) + 1;
		wordsAfter.replace(after, newVal);
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