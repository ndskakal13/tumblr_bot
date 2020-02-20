import java.util.Hashtable;

public class Word {
	
	private Hashtable<String, Integer> wordsBefore, wordsAfter;
	private final String word;
	
	// constructor for a new Word
	public Word(String w, String before, String after)
	{
		this.word = w;
		wordsBefore = new Hashtable<>();
		wordsAfter = new Hashtable<>();
		
		if (before != null)
		{
			wordsBefore.put(before, 1);
		}
		else
		{
			wordsBefore.put("<start>", 1); // update count for starting a phrase
		}
		
		if (after != null)
		{
			wordsAfter.put(after, 1);
		}
		else
		{
			wordsAfter.put("<finish>", 1); // update count for finishing a phrase
		}
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
		if (before != null)
		{
			Integer newVal = wordsBefore.get(before) + 1;
			wordsBefore.replace(before, newVal);
		}
		else
		{
			Integer newVal = wordsBefore.get("<start>") + 1;
			wordsBefore.replace("<start>", newVal);
		}
		
		if (after != null)
		{
			Integer newVal = wordsAfter.get(after) + 1;
			wordsAfter.replace(after, newVal);
		}
		else
		{
			Integer newVal = wordsAfter.get("<finish>") + 1;
			wordsBefore.replace("<finish>", newVal);
		}
	}
}
