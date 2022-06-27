package hurt_me_plenty.tests;

import hurt_me_plenty.content.RegData;
import hurt_me_plenty.content.ResultData;
import hurt_me_plenty.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTaskHMP {
    WebDriver driver;
    PageResult pageResult;

    @BeforeClass
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        pageResult = new HomePageCloud(driver,wait).openPage().searchInfo().openCalculatorPage().switchCalcForm().fillFields();
    }
    //VM Class, Instance type, Region, local SSD, commitment term
    @Test
    public void shouldCreateInstanceWithVMClassContainsRegistrationData(){
        String regDataVMClass = RegData.VM_CLASS;
        String actualVMClass = pageResult.getData(ResultData.VMClassLocator);
        Assert.assertTrue(actualVMClass.contains(regDataVMClass));
    }
    @Test
    public void shouldCreateInstanceWithTypeContainsRegistrationData(){
        String regDataInstanceType = RegData.INSTANCE_TYPE;
        String actualInstanceType = pageResult.getData(ResultData.instanceTypeLocator);
        Assert.assertTrue(actualInstanceType.contains(regDataInstanceType));
    }
    @Test
    public void shouldCreateInstanceWithRegionContainsRegistrationData(){
        String regDataRegion = RegData.REGION;
        String actualRegion = pageResult.getData(ResultData.regionLocator);
        Assert.assertTrue(actualRegion.contains(regDataRegion));
    }
    @Test
    public void shouldCreateInstanceWithLocalSSDContainsRegistrationData(){
        String regDataLocalSSD = RegData.LOCAL_SSD;
        String actualLocalSSD = pageResult.getData(ResultData.localSSDLocator);
        Assert.assertTrue(actualLocalSSD.contains(regDataLocalSSD));
    }
    @Test
    public void shouldCreateInstanceWithCommitmentTermContainsRegistrationData(){
        String regDataCommitmentTerm = RegData.COMMITMENT_TERM;
        String actualCommitmentTerm = pageResult.getData(ResultData.commitmentTerm);
        Assert.assertTrue(actualCommitmentTerm.contains(regDataCommitmentTerm));
    }
    @Test
    public void shouldCreateInstanceWithEstimatedCostEquals(){
        String expectedEstimatedCost = "4,024.56";
        String actualEstimatedCost = pageResult.getData(ResultData.estimateCostLocator);
        Assert.assertTrue(actualEstimatedCost.contains(expectedEstimatedCost));

    }

    @AfterClass
    public void closeBrowser(){
        //driver.quit();
        //driver = null;
    }
}
