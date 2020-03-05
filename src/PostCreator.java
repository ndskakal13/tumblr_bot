import java.util.Random;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class PostCreator {
	
	private WordList wordlist;
	private Hashtable<String, Word> words;
	private ArrayList<Word> startWords;
	Random rand;
	
	public PostCreator(WordList WL)
	{
		wordlist = WL;
		words = WL.getWordList();
		startWords = WL.getFirstWords();
		rand = new Random();
	}
	
	/**
	 *  Purpose: create a post
	 *  Input: none
	 *  @return post: the post to put on the blog
	 *  Assumptions: WordList has been set up
	 */
	public String makePost()
	{
		// this gets stuck in a loop somewhere
		
		Word first = chooseFirstWord();
		Word curWord = first;
		String curWordStr = curWord.getWord();
		String post = curWordStr;
		
		while (curWordStr != "<finish>")
		{
			String nextWord = chooseWord(curWord);
			
			if (nextWord != "<finish>")
			{
				post = post + " " + nextWord; // add word to post
			}
			
			curWordStr = nextWord;
			curWord = wordlist.getWordList().get(curWordStr);
		}
		
		return post;
	}
	
	/**
	 *  Purpose: choose the first word of a post
	 *  Input: none
	 *  @return first: the first word of the post
	 *  Assumptions: none
	 */
	private Word chooseFirstWord()
	{
		int chooseFirst = getRandNo(startWords.size()) - 1; // prevent OutOfBoundsException
		
		return startWords.get(chooseFirst);
	}

	/**
	 *  Purpose: choose the next word of a post
	 *  Input: none
	 *  @return word: next word to be put in post
	 *  Assumptions: none
	 */
	private String chooseWord(Word lastWord)
	{
		int chooseNext = getRandNo(20);
		String nextWord = ""; // default value
		
		
		while (chooseNext >= 0)
		{
			try
			{
				Iterator<String> nextWords = lastWord.wordsAfter.keySet().iterator();
				String cur = null;
				
				while (nextWords.hasNext())
				{
					cur = nextWords.next();
					chooseNext = chooseNext - lastWord.wordsAfter.get(cur);
				
					if (chooseNext <= 0)
					{
						nextWord = cur;
						break;
					}
				}
			}
			catch (NullPointerException ex) // if current word has no words in afterWords
			{
				nextWord = "<finish>";
			}
		}
		return nextWord;
	}
	
	/**
	 *  Purpose: get a random number
	 *  @param max: highest number to go up to (exclusive)
	 *  @return: random integer in (0, max) or next random integer from rand
	 *  Assumptions: none
	 */
	private int getRandNo(int max)
	{
		if (max > 0)
		{
			return rand.nextInt(max) + 1;
		}
		else
		{
			System.out.println("ERR: Received invalid bound for getRandNo."
					+ " Returning 0.");
			return 0;
		}
	}
}