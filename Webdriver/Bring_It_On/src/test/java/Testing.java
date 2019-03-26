import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {

    private WebDriver driver;

    @BeforeTest
    public void enterData() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement searchInputCode = driver.findElement(By.name("paste_code"));
        searchInputCode.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        Select dropDownSyntaxHigh = new Select(driver.findElement(By.name("paste_format")));
        dropDownSyntaxHigh.selectByValue("8");

        Select dropDownPasteExpirat = new Select(driver.findElement(By.name("paste_expire_date")));
        dropDownPasteExpirat.selectByValue("10M");

        WebElement searchInputName = driver.findElement(By.name("paste_name"));
        searchInputName.sendKeys("how to gain dominance among developers");

        WebElement searchButton = driver.findElement(By.id("submit"));
        searchButton.click();
    }

    @Test
    public void testBrowserPageHeaderMatches() {
        Assert.assertTrue(driver.getTitle().contains("[Bash] how to gain dominance among developers - Pastebin.com"));
    }

    @Test
    public void testSyntaxHighlightedForBash() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Bash']")).isDisplayed());
    }

    @Test
    public void testCodeMatch() {
        Assert.assertTrue(driver.findElement(By.id("paste_code")).getText().contains("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force"));
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}