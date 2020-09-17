import java.util.Hashtable;

public class Punctuation {
	
	public Hashtable<Character, Integer> punctBefore, punctAfter;
	
	public Punctuation()
	{
		punctBefore = new Hashtable<>();
		punctAfter = new Hashtable<>();
	}
	
	/***
	 *  Purpose: update a punctuation's before or after
	 *  @param before: punctuation that came before, or null
	 *  @param after: punctuation that came after, or null
	 *  Output: none
	 *  Assumptions: none
	 */
	public void updateWord(Character before, Character after, int weight)
	{
		try
		{
			Integer befVal = punctBefore.get(before) + weight;
			punctBefore.replace(before, befVal);
		}
		catch (NullPointerException ex)
		{
			Integer befVal = 1;
			punctBefore.put(before, befVal);
		}
		
		try
		{
			Integer aftVal = punctAfter.get(after) + weight;
			punctAfter.replace(after, aftVal);
		}
		catch (NullPointerException ex)
		{
			Integer aftVal = 1;
			punctAfter.put(after, aftVal);
		}
	}
	
	public Character getRandPunct(Hashtable<Character, Integer> punctList)
	{
		// TODO: write method
		return null;
	}
	
	public String appendPunct(String word)
	{
		Character bef = getRandPunct(punctBefore);
		Character aft = getRandPunct(punctAfter);
		
		return (bef + word + aft);
	}
	
}