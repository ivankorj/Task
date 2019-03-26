import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement searchInputCode = driver.findElement(By.name("paste_code"));
        searchInputCode.sendKeys("Hello from WebDriver");

        Select dropDown = new Select(driver.findElement(By.name("paste_expire_date")));
        dropDown.selectByValue("10M");

        WebElement searchInputName = driver.findElement(By.name("paste_name"));
        searchInputName.sendKeys("helloweb");

        WebElement searchButton = driver.findElement(By.id("submit"));
        searchButton.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
