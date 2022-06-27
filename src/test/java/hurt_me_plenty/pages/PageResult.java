package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageResult extends AbstractPage{

    public PageResult(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);

    }
    //VM Class, Instance type, Region, local SSD, commitment term

    public String getData(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
    }

    public EmailForm getEmailForm (){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='email_quote']"))).click();
        return new EmailForm(driver,wait);
    }



}
