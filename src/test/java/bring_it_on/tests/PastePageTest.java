package bring_it_on.tests;

import bring_it_on.pages.HomePage;
import bring_it_on.pages.NewPastePage;
import bring_it_on.constants.RegistrationContent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class PastePageTest {
    private WebDriver driver;
    private NewPastePage pastePage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastePage = new HomePage(driver).openPage().createPastePage();
    }
    @Test
    public void shouldCreatePasteWithTitleEqualsPasteName() {
        String actualTitle = pastePage.getTitlePage();
        String expectedTitle = RegistrationContent.PASTE_NAME.getRegContent();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void shouldCreatePasteWithTextEqualsCodeContent() {
        String actualText = pastePage.getCodeText();
        String expectedText = RegistrationContent.CODE_CONTENT.getRegContent();
        Assert.assertEquals(actualText, expectedText, actualText);
    }

    @Test
    public void shouldCreatePasteWithFormatBush() {
        String actualFormat = pastePage.getFormat();
        String expectedFormat = RegistrationContent.FORMAT.getRegContent();
        Assert.assertEquals(actualFormat, expectedFormat);
    }

    @AfterClass(alwaysRun = true)
    public void browserClose(){
        driver.quit();
        driver = null;
    }
}
