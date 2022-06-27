package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageResult extends AbstractPage{
    private String mailButton = "//button[@id='email_quote']";

    public PageResult(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);

    }

    public String getData(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
    }

    public EmailForm getEmailForm (){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(mailButton))).click();
        return new EmailForm(driver,wait);
    }



}
