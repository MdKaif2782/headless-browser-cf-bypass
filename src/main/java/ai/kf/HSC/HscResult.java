package ai.kf.HSC;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HscResult {

    public static void main(String[] args) {
       int roll = 137710;
       String res = getResultWithRollReg(String.valueOf(roll), "1810946599");
       if (res.contains("RESULT NOT FOUND!")){
           System.out.println("No result found for "+roll);
       }else {
           System.out.println("Result found for "+roll);
           System.out.println("Saving result for "+roll);
           saveHtmlToFile(res, "result_"+roll+".html");
           System.out.println("Opening result for "+roll);
           openHtmlFile("result_"+roll+".html");
       }
    }
    public static String getResultWithRollReg(String roll, String reg){
        String result = "";
        String url = "http://www.educationboardresults.gov.bd/result.php"; // Replace with your actual endpoint

        Map<String, String> formData = new HashMap<>();
        formData.put("sr", "1");
        formData.put("et", "2");
        formData.put("exam", "hsc");
        formData.put("year", "2023");
        formData.put("board", "dhaka");
        formData.put("roll", roll);
        formData.put("reg", reg);
        formData.put("value_a", "4");
        formData.put("value_b", "9");
        formData.put("value_s", "13");

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

    public static void saveHtmlToFile(String html, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(html);
            System.out.println("HTML content has been successfully saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving HTML content to file: " + e.getMessage());
        }
    }

    public static void openHtmlFile(String fileName) {
        try {
            File htmlFile = new File(fileName);

            if (htmlFile.exists()) {
                // Open the file with the default system browser
                java.awt.Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.err.println("File not found: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error opening HTML file: " + e.getMessage());
        }
    }
}

