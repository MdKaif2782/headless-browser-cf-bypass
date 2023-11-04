package ai.kf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Udvash {
    public static void main(String[] args) {
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
        System.out.println(driver.getPageSource());

    }
}
