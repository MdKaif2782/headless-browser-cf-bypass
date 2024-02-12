package ai.kf;

import ai.kf.UdvashH.Excel;
import ai.kf.UdvashH.Video;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.Subject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Udvash {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36";
    private static final String BASE_URL = "https://online.udvash-unmesh.com";
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Optional: Start Chrome maximized

        // Specify the path to your extension directory
        options.addExtensions(new File("C:\\Program Files (x86)\\Internet Download Manager\\IDMGCExt.crx"));



        WebDriver driver = Browser.getWebDriver();
        driver.get("https://online.udvash-unmesh.com/Account/Login");

        //Reg input
        WebElement reg = driver.findElement(By.id("RegistrationNumber"));
        reg.sendKeys("1964406");
        WebElement nextBtn = driver.findElement(By.id("btnSubmit"));
        nextBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Maximum wait time in seconds
        wait.until(ExpectedConditions.urlContains("Password"));
        WebElement passwd = driver.findElement(By.id("Password"));
        passwd.sendKeys("kaif0624");
        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();
        wait.until(ExpectedConditions.urlContains("Routine"));
        driver.get("https://online.udvash-unmesh.com/MasterCourse/Class?masterCourseId=1");
        wait.until(ExpectedConditions.urlContains("MasterCourse"));
        //scroll to bottom
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement loadMoreButton = driver.findElement(By.cssSelector("button[class='btn loadMore']"));
        //print if exist
        while (loadMoreButton.isDisplayed()){
            loadMoreButton.click();
            loadMoreButton = driver.findElement(By.cssSelector("button[class='btn loadMore']"));
        }
        System.out.println("All courses loaded");

        //get all courses
        Document doc = Jsoup.parse(driver.getPageSource());
        ArrayList<String> courses = new ArrayList<>();
        ArrayList<Video> videos = new ArrayList<>();
        doc.select("div[class='col-md-6 col-lg-4 course']").forEach(course -> {
            String subjectName = course.select("span.rounded-pill").text();
            String courseName = course.select("h5.card-title").text();
            String lectureNo = course.select("h6.lectureNo").text();
            // Extract the video link
            Element videoLink = course.select("a.btn.videoBtn").first();
            if (videoLink != null){
                String videoUrl = videoLink.attr("href");
                //System.out.println("Video Link: " + videoUrl);
                videos.add(new Video(courseName,videoUrl, lectureNo, subjectName));
                courses.add(videoUrl);
            }else {
                System.out.println("No video found for " + courseName + " " + lectureNo + " " + subjectName + "");
            }

        });
//        Excel.createExcelFile(videos, "Udvash.xlsx");
//        //open the file
//        try {
//            Runtime.getRuntime().exec("cmd /c start Udvash.xlsx");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Get cookies from selenium

        // Close the WebDriver


        int count = 0;
        for (Video course: videos){
            count++;
            String url = BASE_URL + course.getUrl();
           // System.out.println(url);
            driver.get(url);
            //wait 5 sec
            try {
                WebElement divElement = driver.findElement(By.cssSelector("div.page-loading.yt-loading"));
            }catch (Exception e){
                System.out.println("No video found for " + course.getSubject());
                continue;
            }
            WebElement divElement = driver.findElement(By.cssSelector("div.page-loading.yt-loading"));
            wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(divElement, "class", "yt-loading")));
            WebElement iframe = driver.findElement(By.id("yt-player"));
            String src = iframe.getAttribute("src");
            if (src == null){
                System.out.println("No video found");
                continue;
            }
            //get video id from url
            String newUrl = embedToWatchUrl(src);
            System.out.println(count+". "+newUrl);
            course.setUrl(newUrl);
        }
        driver.close();
        Excel.createExcelFile(videos, "Udvash.xlsx");
        //open the file
        try {
            Runtime.getRuntime().exec("cmd /c start Udvash.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String embedToWatchUrl(String embedUrl) {
        // Use a regular expression to extract the video ID from the embed URL
        Pattern pattern = Pattern.compile("/embed/([a-zA-Z0-9_-]+)");
        Matcher matcher = pattern.matcher(embedUrl);

        if (matcher.find()) {
            String videoId = matcher.group(1);

            // Build the watch URL
            String watchUrl = "https://www.youtube.com/watch?v=" + videoId;
            return watchUrl;
        }

        // If the URL doesn't match the expected format, return null or handle the error as needed
        return null;
    }
}
