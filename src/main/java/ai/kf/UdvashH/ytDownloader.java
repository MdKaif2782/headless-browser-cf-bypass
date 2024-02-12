package ai.kf.UdvashH;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ytDownloader {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String embedUrl = "https://www.youtube.com/watch?v=ud6hi1RRidI";

        HttpURLConnection conn = null;
        StringBuilder contents = new StringBuilder();
        try {
            conn = (HttpURLConnection)new URL(embedUrl).openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);

            InputStream is = conn.getInputStream();

            String enc = conn.getContentEncoding();

            if (enc == null) {
                Pattern p = Pattern.compile("charset=(.*)");
                Matcher m = p.matcher(conn.getHeaderField("Content-Type"));
                if (m.find()) {
                    enc = m.group(1);
                }
            }

            if (enc == null)
                enc = "UTF-8";

            BufferedReader br = new BufferedReader(new InputStreamReader(is, enc));

            String line = null;


            while ((line = br.readLine()) != null) {
                contents.append(line);
                contents.append("\n");

            }
        }catch(IOException e) {

        }
        List<String> urlList = new ArrayList<String>();
        Pattern urlencod = Pattern.compile("\"url_encoded_fmt_stream_map\":\"([^\"]*)\"");
        Matcher urlencodMatch = urlencod.matcher(contents.toString());
        if (urlencodMatch.find()) {
            String url_encoded_fmt_stream_map;
            url_encoded_fmt_stream_map = urlencodMatch.group(1);
            Pattern encod = Pattern.compile("url=(.*)");
            Matcher encodMatch = encod.matcher(url_encoded_fmt_stream_map);
            if (encodMatch.find()) {
                String sline = encodMatch.group(1);
                String[] urlStrings = sline.split("url=");
                for (String urlString : urlStrings) {
                    String url = null;
//                    urlString = unescapeJavaString(urlString);
                    Pattern link = Pattern.compile("([^&,]*)[&,]");
                    Matcher linkMatch = link.matcher(urlString);
                    if (linkMatch.find()) {
                        url = linkMatch.group(1);
                        url = URLDecoder.decode(url, StandardCharsets.UTF_8);
                    }
                    urlList.add(url);
                    System.out.println(url);
                }
            }
        }
    }

    public static String unescapeJavaString(String escaped) {
        if (escaped == null) return null;
        StringBuffer result = new StringBuffer(escaped.length());
        Pattern pattern = Pattern.compile("\\\\u[0-9A-Fa-f]{4}|\\\\.");
        Matcher matcher = pattern.matcher(escaped);
        while (matcher.find()) {
            String match = matcher.group();
            if (match.startsWith("\\u")) {
                char unicodeChar = (char) Integer.parseInt(match.substring(2), 16);
                matcher.appendReplacement(result, Character.toString(unicodeChar));
            } else if ("\\\\".equals(match)) {
                matcher.appendReplacement(result, "\\\\");
            } else {
                matcher.appendReplacement(result, match);
            }
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
