import java.util.Random;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class PostCreator {
	
	private WordList wordlist;
	private Hashtable<String, Word> words;
	Random rand;
	
	public PostCreator(WordList WL)
	{
		wordlist = WL;
		words = WL.getWordList();
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
		int chooseFirst = getRandNo(0);
		Word first = new Word("", "", ""); // I have to initialize this to something
		
		while (chooseFirst >= 0)
		{
			Enumeration<Word> firstWords = words.elements();
			while (firstWords.hasMoreElements())
			{
				Word cur = firstWords.nextElement();
				
				if (cur.wordsBefore.get("<start>") != null)
				{
					chooseFirst = chooseFirst - cur.wordsBefore.get("<start>");	
				}
				
				if (chooseFirst <= 0)
				{
					first = cur;
				}
			}
		}
		
		return first;
	}

	/**
	 *  Purpose: choose the next word of a post
	 *  Input: none
	 *  @return word: next word to be put in post
	 *  Assumptions: none
	 */
	private String chooseWord(Word lastWord)
	{
		int chooseNext = getRandNo(0);
		String nextWord = ""; // default value
		
		while (chooseNext >= 0)
		{
			try
			{
				Enumeration<String> nextWords = lastWord.wordsAfter.keys();
				while (nextWords.hasMoreElements())
				{
					String cur = nextWords.nextElement();
					chooseNext = chooseNext - lastWord.wordsAfter.get(cur);
					
					if (chooseNext <= 0)
					{
						nextWord = cur;
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
			return rand.nextInt(max);
		}
		else
		{
			return rand.nextInt();
		}
	}
}