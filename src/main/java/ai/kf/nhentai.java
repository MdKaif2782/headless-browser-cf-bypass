package ai.kf;

import java.util.HashMap;
import java.util.Map;

public class nhentai {
    public static void main(String[] args) {
//        WebDriver driver = Browser.getWebDriver();
//        //set cookies
//        driver.get("http://nhentai.net");
//        driver.manage().addCookie(new Cookie("cf_clearance", "PqmuRdbdEyBSgRCA2NKUCO.b6V.TJxQOMXnPhD_a29c-1698918671-0-1-4afeafd0.6547d2f0.1dfff030-160.0.0"));
//        driver.manage().addCookie(new Cookie("csrftoken", "8GaQ88gTwzKF3seh7OXCgT35N3FfYThDVxAwafhEWlWS7n2VYHALGAeE8YdX5FkE"));
//        driver.navigate().refresh();
//        System.out.println(driver.getPageSource());

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36 Edg/119.0.0.0";
        Map<String, String> cookies = new HashMap<>();
        cookies.put("cf_clearance", "LzI8MtEhhlBTdPiBVpwemrzDSqMKZ9dj8EP1trpyV9k-1699634374-0-1-cacbbfcf.e8fd7a00.9dcae02f-160.0.0");
        cookies.put("csrftoken", "SLdZmNotkiGbNyL7JY4B5r5Bmxnyai2GKejytvsUXc23QJXeVyoQp8YBEpBKf6yN");
//        cookies.put("sessionid","8zg3txpfo2eaymy51brdpkelpmlsmb9a");

        try (NHentaiClient nhentaiClient = new NHentaiClient(userAgent, cookies)) {
            // Your code to interact with NHentai using the client
            nhentaiClient.getDoujin(123450);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
