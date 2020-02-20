import java.util.Scanner;

public class Bot {
	
	private TumblrClient client;
	private Scanner scan;
	
	public Bot()
	{
		client = new TumblrClient("progbot");
		scan = new Scanner(System.in);
	}
	
	/***
	 *  Purpose: Show menu to give user options of what to do
	 *  Input: none
	 *  Output: none
	 *  Assumptions: bot has been set up
	 */
	public void openMenu()
	{
		String input = ""; // default value to ensure loop runs
		System.out.println("What would you like to do?");
		System.out.println("[T]rain, [P]ost, [Q]uit");
		while (!input.equalsIgnoreCase("t") && !input.equalsIgnoreCase("p") && !input.equalsIgnoreCase("q"))
		{
			input = scan.next();
			
			if (!input.equalsIgnoreCase("t") && !input.equalsIgnoreCase("p") && !input.equalsIgnoreCase("q"))
			{
				System.out.println("Please enter a valid input.");
				System.out.println("Would you like to [t]rain, [p]ost, or [q]uit?");
			}
		}
		
		if (input == "t")
		{
			train();
		}
		else if (input == "p")
		{
			makePost();
		}
		else if (input == "q")
		{
			System.out.println("Quitting now.");
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
		client.checkForAsks();
		
		String post = makePost();
		client.createPost(post);
	}
	
	/***
	 *  Purpose: create a text post
	 *  Input: none
	 *  @return post: post to be made
	 *  Assumptions: client has been set up
	 */
	public String makePost()
	{
		String post = "";
		
		// TODO: add post-making algorithm
		
		return post;
	}
	
	/***
	 *  Purpose: train the bot with text data
	 *  Input: none
	 *  Output: none
	 *  Assumptions:
	 */
	public void train()
	{
		// TODO: add training algorithm
	}

}
