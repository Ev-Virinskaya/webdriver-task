package hurt_me_plenty.tests;

import hurt_me_plenty.content.ResultData;
import hurt_me_plenty.pages.EmailPage;
import hurt_me_plenty.pages.HomePageCloud;
import hurt_me_plenty.pages.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TaskHardcoreTest {
    private WebDriver driver;
    private ResultPage resultPage;
    private EmailPage emailPage;
    private String pageCost;

    @BeforeClass
    public void setupBrowser(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        resultPage = new HomePageCloud(driver,wait).openPage().searchInfo().openCalculatorPage().switchCalcForm().fillFields();
        pageCost = resultPage.getData(ResultData.ESTIMATE_COST_LOCATOR);
        emailPage = resultPage.getEmailForm().sendEmail().openEmailPage();
    }

    @Test
    public void shouldEmailEstimatedCostEqualsPageResultEstimatedCost(){
        String expectedCost = pageCost;
        String actualCost = emailPage.getEstimateCost();

        Assert.assertTrue(expectedCost.contains(actualCost));

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
