package ai.kf;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Browser {
    public static void main(String[] args) throws InterruptedException, IOException {
        String chromeBinaryPath = "C:\\Users\\KAIF\\Downloads\\Compressed\\Win_907430_chrome-win\\chrome-win\\chrome.exe"; // Change this to your actual Chrome binary path
        String chromeDriverPath = "C:\\Users\\KAIF\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe" ;
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeBinaryPath);
        options.addArguments( "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://nhentai.net");


        // Switch to the iframe by index (0 in this example, you may need to adjust it)
        while (driver.getTitle().contains("Just a")) {
            Thread.sleep(10000);
            driver.switchTo().frame(0);
            WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
            Point point = checkbox.getLocation();
            Actions actions = new Actions(driver);
            // Move to the desired point (e.g., a specific coordinate on the element)
            actions.moveToElement(checkbox, point.x, point.y).click().perform();

            checkbox.click();
        }

        //ss
        takeScreenshot(driver);
    }

    public static WebDriver getWebDriver(){
        String chromeBinaryPath = "C:\\Users\\KAIF\\Downloads\\Compressed\\Win_907430_chrome-win\\chrome-win\\chrome.exe"; // Change this to your actual Chrome binary path
        String chromeDriverPath = "C:\\Users\\KAIF\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe" ;
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeBinaryPath);
        options.addArguments( "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        return new ChromeDriver(options);
    }

    public static void takeScreenshot(WebDriver driver) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "src/screenshot.png";
        // Copy the screenshot file to the specified path
        File destinationFile = new File(screenshotPath);
        ImageIO.write(ImageIO.read(screenshotFile), "png", destinationFile);
        System.out.println("Screenshot saved to: " + screenshotPath);
        System.out.println(driver.getPageSource());
    }
}
