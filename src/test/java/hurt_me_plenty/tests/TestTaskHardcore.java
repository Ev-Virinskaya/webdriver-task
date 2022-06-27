package hurt_me_plenty.tests;

import hurt_me_plenty.content.ResultData;
import hurt_me_plenty.pages.EmailPage;
import hurt_me_plenty.pages.HomePageCloud;
import hurt_me_plenty.pages.PageResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTaskHardcore {
    WebDriver driver;
    PageResult pageResult;
    EmailPage emailPage;
    String pageCost;

    @BeforeClass
    public void setupBrowser(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pageResult = new HomePageCloud(driver,wait).openPage().searchInfo().openCalculatorPage().switchCalcForm().fillFields();
        pageCost = pageResult.getData(ResultData.estimateCostLocator);
        emailPage = pageResult.getEmailForm().sendEmail().openEmailPage();
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
