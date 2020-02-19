import java.util.List;
import com.tumblr.jumblr;

public class jumblrClient {
	
	private List<String> TAGS = new List<>();
	TAGS.add("bot");
	
	private final String CONSUMER_KEY, CONSUMER_SECRET, OAUTH_KEY, OAUTH_SECRET, USERNAME, TAGS;
	private JumblrClient tumblr;
	private Blog blog;
	
	public jumblrClient(String blogName)
	{
		// ensure this is changed to your blog name
		USERNAME = blogName;
		TAGS.add(blogName); // you can change this if you want
		
		// ensure these are set correctly with the given names
		CONSUMER_KEY = System.getenv("CONSUMER_KEY");
		CONSUMER_SECRET = System.getenv("CONSUMER_SECRET");
		OAUTH_KEY = System.getenv("OAUTH_KEY");
		OAUTH_SECRET = System.getenv("OAUTH_SECRET");
		
		// create JumblrClient object
		blog = new Blog();
		tumblr = new JumblrClient(CONSUMER_KEY, CONSUMER_SECRET, OAUTH_KEY, OAUTH_SECRET);
		blog.setClient(tumblr);
	}
	
	public void createPost(String post)
	{
		// untested as I haven't been able to connect my bot yet
		TextPost t = tumblr.newPost(USERNAME, TextPost);
		t.setBody(post);
		t.setTags(TAGS);
		t.save();
	}
	
	public void answerAsk(AnswerPost ask)
	{
		// untested as I haven't been able to connect my bot yet
		// trying to find a way to set answer
	}
	
	public void checkForAsks()
	{
		List<Post> asks = blog.submissions();
		
		for (ask a : asks)
		{
			answerAsk(a);
		}
	}
}