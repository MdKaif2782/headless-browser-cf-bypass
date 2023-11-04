package ai.kf.Reddit;

import org.jsoup.nodes.Element;

public class RedditPost {
    private String id;
    private String type;
    private int gildings;
    private String whitelistStatus;
    private boolean isGallery;
    private String author;
    private String authorFullname;
    private String subreddit;
    private String subredditPrefixed;
    private String subredditFullname;
    private String subredditType;
    private long timestamp;
    private String url;
    private String permalink;
    private String domain;
    private int rank;
    private int commentsCount;
    private int score;
    private boolean promoted;
    private boolean nsfw;
    private boolean spoiler;
    private boolean oc;
    private int numCrossposts;
    private String context;
    private String title;
    private String thumbnailUrl;
    private String postUrl;
    private String expandoData;
    private String expandoHtml;

    // Constructor
    public RedditPost() {
        // Initialize your fields here if needed.
    }

    // Getters and setters for each field

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Define getters and setters for other fields similarly...

    // You can add methods to set or extract data from the HTML as needed.

    // Example method to populate the object from the HTML
    public void extractDataFromHtml(Element postDiv) {
        // Extract data from the provided HTML and set the fields of the RedditPost object.
        this.id = postDiv.attr("id");
        this.type = postDiv.attr("data-type");
        String gildingsStr = postDiv.attr("data-gildings");
        this.gildings = gildingsStr.isEmpty() ? 0 : Integer.parseInt(gildingsStr);
        this.whitelistStatus = postDiv.attr("data-whitelist-status");
        this.isGallery = Boolean.parseBoolean(postDiv.attr("data-is-gallery"));
        this.author = postDiv.attr("data-author");
        this.authorFullname = postDiv.attr("data-author-fullname");
        this.subreddit = postDiv.attr("data-subreddit");
        this.subredditPrefixed = postDiv.attr("data-subreddit-prefixed");
        this.subredditFullname = postDiv.attr("data-subreddit-fullname");
        this.subredditType = postDiv.attr("data-subreddit-type");
        this.timestamp = postDiv.attr("data-timestamp").isEmpty() ? 0 : Long.parseLong(postDiv.attr("data-timestamp"));
        this.url = postDiv.attr("data-url");
        this.permalink = postDiv.attr("data-permalink");
        this.domain = postDiv.attr("data-domain");
        this.rank = postDiv.attr("data-rank").isEmpty() ? 0 : Integer.parseInt(postDiv.attr("data-rank"));
        this.commentsCount = postDiv.attr("data-comments-count").isEmpty() ? 0 : Integer.parseInt(postDiv.attr("data-comments-count"));
        this.score = postDiv.attr("data-score").isEmpty() ? 0 : Integer.parseInt(postDiv.attr("data-score"));
        this.promoted = Boolean.parseBoolean(postDiv.attr("data-promoted"));
        this.nsfw = Boolean.parseBoolean(postDiv.attr("data-nsfw"));
        this.spoiler = Boolean.parseBoolean(postDiv.attr("data-spoiler"));
        this.oc = Boolean.parseBoolean(postDiv.attr("data-oc"));
        this.numCrossposts = postDiv.attr("data-num-crossposts").isEmpty() ? 0 : Integer.parseInt(postDiv.attr("data-num-crossposts"));
        this.context = postDiv.attr("data-context");

        // Extract title, thumbnail, post URL, and other data as needed.
        Element titleElement = postDiv.selectFirst("p.title a.title");
        if (titleElement != null) {
            this.title = titleElement.text();
            this.postUrl = titleElement.attr("href");
        }

        Element thumbnailElement = postDiv.selectFirst("a.thumbnail img");
        if (thumbnailElement != null) {
            this.thumbnailUrl = thumbnailElement.attr("src");
        }

        Element expandoElement = postDiv.selectFirst("div.expando-button");
        if (expandoElement != null) {
            this.expandoData = expandoElement.attr("data-cachedhtml");
        }

        // You can continue to extract other data based on your needs.
    }

    @Override
    public String toString() {
        // Return a string representation of the Reddit post object, including all fields.
        return "RedditPost{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", gildings=" + gildings +
                ", whitelistStatus='" + whitelistStatus + '\'' +
                ", isGallery=" + isGallery +
                ", author='" + author + '\'' +
                ", authorFullname='" + authorFullname + '\'' +
                ", subreddit='" + subreddit + '\'' +
                ", subredditPrefixed='" + subredditPrefixed + '\'' +
                ", subredditFullname='" + subredditFullname + '\'' +
                ", subredditType='" + subredditType + '\'' +
                ", timestamp=" + timestamp +
                ", url='" + url + '\'' +
                ", permalink='" + permalink + '\'' +
                ", domain='" + domain + '\'' +
                ", rank=" + rank +
                ", commentsCount=" + commentsCount +
                ", score=" + score +
                ", promoted=" + promoted +
                ", nsfw=" + nsfw +
                ", spoiler=" + spoiler +
                ", oc=" + oc +
                ", numCrossposts=" + numCrossposts +
                ", context='" + context + '\'' +
                ", title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", expandoData='" + expandoData + '\'' +
                ", expandoHtml='" + expandoHtml + '\'' +
                '}';
    }

    // Define other methods as needed.
    // get title
    public String getTitle() {
        return title;
    }
}

