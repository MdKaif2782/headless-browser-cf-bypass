package ai.kf.meme;

import ai.kf.meme.model.Meme;
import ai.kf.scrapping.chiral.suicidenews.Scrap;
import com.google.gson.Gson;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String url = "https://meme-api.com/gimme";
        String memeRes = Scrap.getJsonRes(url);
        Gson gson = new Gson();
        Meme meme = gson.fromJson(memeRes, Meme.class);
        System.out.println(meme.getUrl());
    }
}
