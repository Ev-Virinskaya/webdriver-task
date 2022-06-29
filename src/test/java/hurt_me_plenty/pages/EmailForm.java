package hurt_me_plenty.pages;

import hurt_me_plenty.WindowsSwitcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EmailForm extends AbstractPage {
    private static final String EMAIL_INPUT_LOCATOR = "//input[@type='email']";
    private static final String EMAIL_BUTTON_LOCATOR = "//button[@aria-label='Send Email']";

    private EmailGeneratorPage emailGeneratorPage;

    public EmailForm(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private String createEmail(){
        driver = WindowsSwitcher.openNewWindow(driver);
        emailGeneratorPage = new EmailGeneratorPage(driver,wait);
        return emailGeneratorPage.generateEmailAddress();
    }


    public EmailGeneratorPage sendEmail(){
        String email = createEmail();
        //вынести в абстрактный класс (есть такой же кусок на CalculatorPage)
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAIL_INPUT_LOCATOR))).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_BUTTON_LOCATOR))).click();
        WindowsSwitcher.switchToWindow(driver);
        return emailGeneratorPage;
    }
}
