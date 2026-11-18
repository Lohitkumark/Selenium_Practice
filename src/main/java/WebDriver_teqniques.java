import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class WebDriver_teqniques {
    static void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String name = "john";
        String searchText = "ind";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // auto suggest dropdown
        driver.findElement(By.id("autosuggest")).sendKeys(searchText);
        Thread.sleep(3000);
       List<WebElement> items =  driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

       for(WebElement item : items){
           if(item.getText().equalsIgnoreCase("India")){
               item.click();
               break;
           }
       }

        // dynamic dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();

        // date select (current date)
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        // custom dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for(int i=1; i<5;i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        // static dropdown
        WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select select = new Select(element);
        select.selectByIndex(2);

        // check box
        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();

        // submit button
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

        driver.close();
    }
}
