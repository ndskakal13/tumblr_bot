import java.util.LinkedList;
import java.util.List;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.AnswerPost;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.TextPost;

public class jumblrClient {
	
	LinkedList<String> TAGS;
	
	private final String CONSUMER_KEY, CONSUMER_SECRET, OAUTH_KEY, OAUTH_SECRET, USERNAME;
	private JumblrClient tumblr;
	private Blog blog;
	
	public jumblrClient(String blogName)
	{
		// ensure this is changed to your blog name
		USERNAME = blogName;
		TAGS = new LinkedList<>();
		TAGS.add("bot");
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
		TextPost t = new TextPost();
		try {
			t = tumblr.newPost(USERNAME, t.getClass());
		} catch (IllegalAccessException e) {
			System.out.println("ERR: IllegalAccessException. Unable to create post.");
			e.printStackTrace();
			t = null;
		} catch (InstantiationException e) {
			System.out.println("ERR: InstantiationException. Unable to create post.");
			e.printStackTrace();
			t = null;
		}
		
		if (t != null)
		{
			t.setBody(post);
			t.setTags(TAGS);
			t.save();
		}
		
	}
	
	public void answerAsk(Post ask)
	{
		// untested as I haven't been able to connect my bot yet
		// trying to find a way to set answer
	}
	
	public void checkForAsks()
	{
		List<Post> asks = blog.submissions();
		
		for (Post a : asks)
		{
			answerAsk(a);
		}
	}
}