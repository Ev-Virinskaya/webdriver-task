package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends AbstractPage{
    private static final String MAIL_BUTTON = "//button[@id='email_quote']";

    public ResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);

    }

    public String getData(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
    }

    public EmailForm getEmailForm (){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MAIL_BUTTON))).click();
        return new EmailForm(driver,wait);
    }



}
