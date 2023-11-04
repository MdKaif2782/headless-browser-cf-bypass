package ai.kf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fblogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Browser.getWebDriver();
        driver.get("https://www.facebook.com");

        // Find the email/phone input field and enter your email/phone
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("mibnzaman02@gmail.com");

        // Find the password input field and enter your password
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("@bcd.net");

        // Find and click the "Log In" button
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        Thread.sleep(10000);
        WebElement messageButton = driver.findElement(By.xpath("//div[contains(text(),'Messenger')]"));

        // Click on the "Message" button
        messageButton.click();
    }
}
