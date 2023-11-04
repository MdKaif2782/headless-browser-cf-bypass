package ai.kf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ZenRows {
        public static void main(final String... args) throws Exception {
            try {
                String url = "https://api.zenrows.com/v1/?apikey=07ff7fc85f720c1db258bf8ef1c96c1a5ca32694&url=https://nhentai.net";

                // Create a URL object
                URL obj = new URL(url);

                // Open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

                // Set the HTTP request method (GET, POST, etc.)
                connection.setRequestMethod("GET");

                // Get the response code
                int responseCode = connection.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                // Read the response data
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print the response
                System.out.println("Response Data:");
                System.out.println(response.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
