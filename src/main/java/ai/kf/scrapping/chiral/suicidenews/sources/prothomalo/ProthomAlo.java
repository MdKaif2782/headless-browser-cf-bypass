package ai.kf.scrapping.chiral.suicidenews.sources.prothomalo;

import ai.kf.scrapping.chiral.suicidenews.sources.prothomalo.model.News;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ProthomAlo {
    private static final Logger log = LogManager.getLogger(ProthomAlo.class);

    public static void main(String[] args) throws IOException {
        int limit = 600;
        String url = "https://en.prothomalo.com/api/v1/advanced-search?section-id=16600%2C16725%2C16727%2C16728%2C17129%2C17134%2C17135%2C17136%2C17137%2C17139%2C35627&q=heat+stroke&offset=0&limit="+limit+"&fields=headline%2Csubheadline%2Cslug%2Curl%2Ctags%2Chero-image-s3-key%2Chero-image-caption%2Chero-image-metadata%2Clast-published-at%2Calternative%2Cauthors%2Cauthor-name%2Cauthor-id%2Csections%2Cstory-template%2Cmetadata%2Chero-image-attribution%2Caccess";
        String res = getJsonRes(url);
        Gson gson = new Gson();
        News news = gson.fromJson(res, News.class);


        ArrayList<News.Item> expected = new ArrayList<>();
        ArrayList<News.Item> items = (ArrayList<News.Item>) news.getItems();


        for (News.Item item : items) {
//            if (item.getHeadline().toLowerCase().contains("heat") ||
//                item.getHeadline().toLowerCase().contains("stroke") ||
//                item.getHeadline().toLowerCase().contains("death") ||
//                item.getHeadline().toLowerCase().contains("dead") ||
//                item.getHeadline().toLowerCase().contains("died") ||
//                item.getHeadline().toLowerCase().contains("stress")
//            ) {
//                expected.add(item);
//            }
            ArrayList<News.Tag> tags= (ArrayList<News.Tag>) item.getTags();
            for (News.Tag tag:tags) {
                if(!tag.getName().contains("heat")) return;
            }
            for (News.Tag tag: tags) {
                if(!tag.getName().contains("death")) return;
            }
            expected.add(item);
        }

        int count = 0;
        for (News.Item item : expected) {
            count++;
            System.out.println(count+ " "+item.getHeadline());
        }
    }


    public static String getJsonRes(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}

