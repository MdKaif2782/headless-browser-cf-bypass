package ai.kf.MBBS;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class BruteforceMBBS {
    public static void main(String[] args) {
        String start_roll = "9900000";
        String end_roll = "9906000";
        String name = "Tawhid Ibne Mamun";
        String result = bruteForceMBBS(start_roll, end_roll, name);
        System.out.println(result);
    }
    public static String bruteForceMBBS(String start, String end, String name){
        String result = "";
        for (int i = Integer.parseInt(start); i <= Integer.parseInt(end); i++) {
            String roll = String.format("%06d", i);
            String res = getMBBSResult(roll);
            if (res.toLowerCase().contains(name.toLowerCase())){
                result = "Result found for "+roll;
                break;
            }else {
                result = "No result found for "+roll;
                System.out.println("Progress "+i+"/"+end);
            }
        }
        return result;
    }
    public static String getMBBSResult(String roll){
        String result = "";
        String url = "http://dgme.teletalk.com.bd/mbbs/options/result.php"; // Replace with your actual endpoint

        Map<String, String> formData = new HashMap<>();
        formData.put("yes", "YES");
        formData.put("button01", "submit");
        formData.put("roll_no", roll);


        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Set the request method
            connection.setRequestMethod("POST");

            // Enable input/output streams
            connection.setDoOutput(true);

            // Set the content type for a multipart/form-data request
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------123456789012345678901234567890");

            // Create the form data payload
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                postData.append("-----------------------------123456789012345678901234567890\r\n");
                postData.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
                postData.append(entry.getValue() + "\r\n");
            }

            // Add the end boundary
            postData.append("-----------------------------123456789012345678901234567890--");

            // Write the data to the connection
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(postData.toString());
                wr.flush();
            }

            // Get the response code
            int responseCode = connection.getResponseCode();
            // System.out.println("Response Code: " + responseCode);

            // Read the response
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Print the response
                // System.out.println("Response: " + response.toString());
                result = response.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
