package bring_it_on.tests;

import constants.RegistrationContent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewPaste;

public class TestPastePage {
    private WebDriver driver;
    private NewPaste pastePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void newPastePageSetup() {
        pastePage = new HomePage(new ChromeDriver()).openPage().createPastePage();
    }

    @Test
    public void shouldCreatePasteWithTitleEqualsPasteName() {
        String actualTitle = pastePage.getTitlePage();
        String expectedTitle = RegistrationContent.PASTE_NAME.getRegContent();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void shouldCreatePasteWithTextEqualsCodeContent() {
        String actualText = pastePage.getText();
        String expectedText = RegistrationContent.CODE_CONTENT.getRegContent();
        Assert.assertEquals(actualText, expectedText, actualText);
    }

    @Test
    public void shouldCreatePasteWithFormatBush() {
        String actualFormat = pastePage.getSyntax();
        String expectedFormat = RegistrationContent.FORMAT.getRegContent();
        Assert.assertEquals(actualFormat, expectedFormat);
    }
}
