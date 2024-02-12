package ai.kf.ACPS_Database;

import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.CookieManager;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StudentSearch {
    public static void main(String[] args) throws IOException {
     for (int i = 1; i <= 40; i++) {
         if (getPage(i).toLowerCase().contains("rakibul")){
             System.out.println("Found at page "+i);
         }else {
             System.out.println("Progress "+i+"/40");
         }
     }
    }
    public static String getPage(int pageNo) throws IOException {
        // Create a new OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        // Define the URL with the page parameter
        String url = "http://crvs-institute.banbeis.gov.bd/students-list?page="+pageNo;

        String cookieJson = new String(Files.readAllBytes(Paths.get("C:\\Users\\KAIF\\IdeaProjects\\headless-browser-cf-bypass\\src\\main\\java\\ai\\kf\\ACPS_Database\\cookie.json")));

        // Print the JSON string
        // System.out.println(cookieJson);
        // Prepare the cookies from the provided JSON
        StringBuilder cookieBuilder = new StringBuilder();
        // Parse the cookie JSON and add cookies to the OkHttpClient
        try {
            JSONParser parser = new JSONParser();

            JSONArray cookiesArray = (JSONArray) parser.parse(cookieJson);
            for (int i = 0; i < cookiesArray.size(); i++) {
                JSONObject cookieObject = (JSONObject) cookiesArray.get(i);
                String name = cookieObject.get("name").toString();
                String value = cookieObject.get("value").toString();
                cookieBuilder.append(name).append("=").append(value).append("; ");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cookie", cookieBuilder.toString())
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            assert response.body() != null;
            String res = response.body().string();
          //  System.out.println(res);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
