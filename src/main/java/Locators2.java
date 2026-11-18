import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    static void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String name = "john";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String successMessage = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(successMessage, "You are successfully logged in.");
        String getName = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        Assert.assertEquals(getName, "Hello "+ name+",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
    }

}
