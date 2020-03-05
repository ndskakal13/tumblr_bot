// all uses of the TumblrClient class are currently commented out as the class is untested

import java.util.Scanner;

public class Bot {
	
	// private TumblrClient client;
	private PostCreator postMaker;
	private WordList wordlist;
	private Scanner scan;
	private BOT_STATE state;
	
	public Bot()
	{
		// client = new TumblrClient("progbot");
		scan = new Scanner(System.in);
		wordlist = new WordList();
		postMaker = new PostCreator(wordlist);
		state = BOT_STATE.MENU;
	}
	
	/***
	 *  Purpose: Show menu to give user options of what to do
	 *  Input: none
	 *  Output: none
	 *  Assumptions: bot has been set up
	 */
	public void go()
	{
		while (state != BOT_STATE.QUIT)
		{
			switch (state)
			{
				case MENU:
					String input = ""; // default value to ensure loop runs
					System.out.println("What would you like to do?");
					System.out.println("[T]rain, [P]ost, [C]hat, [Q]uit");
					while (!input.equalsIgnoreCase("t") && !input.equalsIgnoreCase("p")
							&& !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("q"))
					{
						input = scan.nextLine();
						
						if (!input.equalsIgnoreCase("t") && !input.equalsIgnoreCase("p")
								&& !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("q"))
						{
							System.out.println("Please enter a valid input.");
							System.out.println("Would you like to [t]rain, [p]ost, [c]hat,"
									+ " or [q]uit?");
						}
					}
					
					if (input.equalsIgnoreCase("t"))
					{
						state = BOT_STATE.TRAIN;
						break;
					}
					else if (input.equalsIgnoreCase("p"))
					{
						state = BOT_STATE.CREATE_POST;
						break;
					}
					else if (input.equalsIgnoreCase("c"))
					{
						state = BOT_STATE.CHAT;
						break;
					}
					else if (input.equalsIgnoreCase("q"))
					{
						System.out.println("Quitting now.");
						state = BOT_STATE.QUIT;
						break;
					}
				
				case TRAIN:
					train();
					state = BOT_STATE.MENU;
					break;
					
				case CREATE_POST:
					makePost();
					state = BOT_STATE.MENU;
					break;
					
				case RUN_BOT:
					runBot();
					state = BOT_STATE.MENU;
					break;
					
				case CHAT:
					chat();
					state = BOT_STATE.MENU;
					break;
					
				case QUIT:
					break; // case shouldn't happen but this will just end the program if it does
			}
		}
		
		
	}
	
	/***
	 *  Purpose: run the bot's main interactions
	 *  Input: none
	 *  Output: none
	 *  Assumptions: client has been set up
	 */
	public void runBot()
	{
		// TODO: implement TumblrClient once tested
		// client.checkForAsks();
		// makePost();
		
		state = BOT_STATE.MENU;
	}
	
	/***
	 *  Purpose: create a text post
	 *  Input: none
	 *  @return post: post to be made
	 *  Assumptions: client has been set up
	 */
	public void makePost()
	{
		String post = postMaker.makePost();
		
		// TODO: implement TumblrClient once tested
		// client.createPost(post);
		System.out.println(post);
	}
	
	/***
	 *  Purpose: train the bot with text data
	 *  Input: none
	 *  Output: none
	 *  Assumptions: none
	 */
	public void train()
	{
		String input = "";
		
		System.out.println("Enter the text to train the bot with"
				+ " (one line at a time, please).");
		System.out.println("When done, just enter 'n'.");
		
		while (!input.equalsIgnoreCase("N"))
		{
			input = scan.nextLine();
			if (!input.equalsIgnoreCase("N")) // prevent from adding "n"
			{
				wordlist.readInput(input, 10);
			}
		}
	}
	
	public void chat()
	{
		System.out.println("Enter text and hit enter and the bot will respond.");
		System.out.println("Enter 'n' to quit.");
		
		String input = "";
		while (!input.equalsIgnoreCase("N"))
		{
			input = scan.nextLine();
			if (!input.equalsIgnoreCase("N")) // prevent from adding "n"
			{
				wordlist.readInput(input, 1);
				makePost();
			}		
		}
	}
}