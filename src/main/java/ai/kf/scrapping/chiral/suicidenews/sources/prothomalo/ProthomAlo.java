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

public class ProthomAlo {
    private static final Logger log = LogManager.getLogger(ProthomAlo.class);

    public static void main(String[] args) throws IOException {
        String url = "https://en.prothomalo.com/api/v1/advanced-search?section-id=16600%2C16601%2C16603%2C16604%2C16605%2C16606%2C16607%2C16610%2C16619%2C16622%2C16623%2C16624%2C16725%2C16727%2C16728%2C16739%2C16740%2C16741%2C16742%2C16743%2C16744%2C16745%2C16746%2C16747%2C16748%2C16751%2C16752%2C16756%2C16762%2C16763%2C16764%2C16765%2C16766%2C16767%2C16768%2C16770%2C16771%2C16772%2C16773%2C16774%2C16775%2C16776%2C16781%2C17111%2C17129%2C17130%2C17131%2C17134%2C17135%2C17136%2C17137%2C17138%2C17139%2C17140%2C17143%2C17144%2C17202%2C35627%2C35628%2C35629%2C35639%2C35640&q=heat+stroke&sort=latest-published&offset=35&limit=50&fields=headline%2Csubheadline%2Cslug%2Curl%2Ctags%2Chero-image-s3-key%2Chero-image-caption%2Chero-image-metadata%2Clast-published-at%2Calternative%2Cauthors%2Cauthor-name%2Cauthor-id%2Csections%2Cstory-template%2Cmetadata%2Chero-image-attribution%2Caccess";
        String res = getJsonRes(url);
        System.out.println(res);
        Gson gson = new Gson();
        News news = gson.fromJson(res, News.class);
        System.out.println(news.getItems().get(0).getHeadline());
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

