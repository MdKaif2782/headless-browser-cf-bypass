package ai.kf;

import ai.kf.Reddit.RedditPost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;

public class RedditScrapper {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36";
    private static final String BASE_URL = "https://old.reddit.com";
    public static void main(String[] args) {
        String subreddit = "dankmemes";
        String url = "https://old.reddit.com/r/"+subreddit; // Replace with the URL of the webpage you want to scrape.

        try {
            // Connect to the webpage and fetch its content.
            //add cookies
            Document document = Jsoup.connect(url)
                    .userAgent(USER_AGENT)
                    .get();
            // Select the parent div that contains the list of posts using a CSS selector.
            Element parentDiv = document.getElementById("siteTable");

            if (parentDiv != null) {
                // Find all the child divs within the parent div.
                Elements postDivs = parentDiv.select("div[id^=thing]"); // Adjust the selector based on your HTML structure.
                // Loop through the post divs and extract the data you need.
                for (Element postDiv : postDivs) {
                    if (postDiv.hasClass("clearleft") ) {
                        continue; // Skip this post and continue with the next one.
                    }
                    RedditPost post = new RedditPost();
                    post.extractDataFromHtml(postDiv);

                    if (post.getTitle() != null && !post.getTitle().isEmpty()) {
                        System.out.println(post);
                    }else {
                        System.out.println("Title not found for post: " + post.getId());
                    }
                }
            } else {
                System.out.println("Parent div not found on the webpage.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
