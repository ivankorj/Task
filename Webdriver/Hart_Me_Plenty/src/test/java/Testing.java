import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {
    private WebDriver driver;

    @BeforeTest
    public void enterData() {
        driver = new ChromeDriver();

        //1. Открыть https://cloud.google.com/
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        //2. Нажать на кнопку EXPLORE ALL PRODUCTS
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='exploreProducts']")));
        WebElement searchExploreAllProdBtn = driver.findElement(By.xpath("//*[@track-name='exploreProducts']"));
        searchExploreAllProdBtn.click();

        //3. Нажать на кнопку SEE PRICING
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='seePricing']")));
        WebElement searchSeePricingBtn = driver.findElement(By.xpath("//*[@track-name='seePricing']"));
        searchSeePricingBtn.click();

        //4. В панели слева выбрать Calculators
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='pricingNav/calculators']")));
        WebElement searchCalculatorsBtn = driver.findElement(By.xpath("//*[@track-name='pricingNav/calculators']"));
        searchCalculatorsBtn.click();

        //5. Активировать раздел COMPUTE ENGINE вверху страницы
        new WebDriverWait(driver,15).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("idIframe")));
        WebElement searchComputeEngine = driver.findElement(By.xpath("//*[@title='Compute Engine']"));
        searchComputeEngine.click();

        //6. Заполнить форму следующими данными:
        //Number of instances: 4
        WebElement searchNumberOfInstanc = driver.findElement(By.name("quantity"));
        searchNumberOfInstanc.sendKeys("4");

        //Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
        WebElement searchOperatingSystem = driver.findElement(By.id("select_value_label_40"));
        searchOperatingSystem.click();
        WebElement choiceOperatingSystem = driver.findElement(By.id("select_option_48"));
        choiceOperatingSystem.click();

        //VM Class: Regular
        WebElement searchVMClass = driver.findElement(By.id("select_value_label_41"));
        searchVMClass.click();
        WebElement choiceVMClass = driver.findElement(By.id("select_option_60"));
        choiceVMClass.click();

        //Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        WebElement searchInstanceType = driver.findElement(By.id("select_value_label_42"));
        searchInstanceType.click();
        WebElement choiceInstanceType = driver.findElement(By.id("select_option_70"));
        choiceInstanceType.click();

        //Выбрать Add GPUs
        WebElement searchAddGPUs = driver.findElement(By.xpath("//*[@aria-label='Add GPUs']"));
        searchAddGPUs.click();

        //* Number of GPUs: 1
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("select_value_label_327")));
        WebElement searchNumberOfGPUs = driver.findElement(By.id("select_329"));
        searchNumberOfGPUs.click();
        WebElement choiceNumberOfGPUs = driver.findElement(By.id("select_option_334"));
        choiceNumberOfGPUs.click();

        //* GPU type: NVIDIA Tesla V100
        WebElement searchGPUType = driver.findElement(By.id("select_331"));
        searchGPUType.click();
        WebElement choiceGPUType = driver.findElement(By.id("select_option_341"));
        choiceGPUType.click();

        //* Local SSD: 2x375 Gb
        WebElement searchLocalSSD = driver.findElement(By.id("select_95"));
        searchLocalSSD.click();
        WebElement choiceLocalSSD = driver.findElement(By.id("select_option_182"));
        choiceLocalSSD.click();

        //* Datacenter location: Frankfurt (europe-west3)
        WebElement searchDatacenterLocation = driver.findElement(By.id("select_97"));
        searchDatacenterLocation.click();
        WebElement choiceDatacenterLocation = driver.findElement(By.id("select_option_196"));
        choiceDatacenterLocation.click();

        //* Commited usage: 1 Year
        WebElement searchCommitedUsage = driver.findElement(By.id("select_102"));
        searchCommitedUsage.click();
        WebElement choiceCommitedUsage = driver.findElement(By.id("select_option_100"));
        choiceCommitedUsage.click();

        //7. Нажать Add to Estimate
        WebElement searchAddToEstimateBtn = driver.findElement(By.xpath("//*[@id='mainForm']//form/div/button"));
        searchAddToEstimateBtn.click();
    }


    @Test
    public void testVMClassCompliance() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='compute']//md-list-item[2]")).getText().contains("VM class: regular"));
    }

    @Test
    public void testInstanceTypeConformance() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='compute']//md-list-item[3]")).getText().contains("Instance type: n1-standard-8"));
    }

    @Test
    public void testRegionConformance() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='compute']//md-list-item[4]")).getText().contains("Region: Frankfurt"));
    }

    @Test
    public void testLocalSSDConformance() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='compute']//md-list-item[5]")).getText().contains("Total available local SSD space 2x375 GB"));
    }

    @Test
    public void testCommitmentTermConformance() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='compute']//md-list-item[6]")).getText().contains("Commitment term: 1 Year"));
    }

    @Test
    public void testCorrespondingRentalAmountPerMonth() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//md-card-content//div/h2")).getText().contains("Total Estimated Cost: USD 1,187.77 per 1 month"));
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}