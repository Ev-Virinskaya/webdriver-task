package hurt_me_plenty.pages;

import hurt_me_plenty.WindowsSwitcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailGeneratorPage extends AbstractPage {
    public EmailGeneratorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        String addressEmailGenerator = "https://yopmail.com/";
        driver.get(addressEmailGenerator);
    }

    public String generateEmailAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='listeliens']/a[@href='email-generator']"))).click();
        String email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='egen']"))).getText();
        //driver.close();
        driver = WindowsSwitcher.switchWindow(driver);
        return email;
    }

    public EmailPage openEmailPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@onclick='egengo();']"))).click();
        return new EmailPage(driver, wait);
    }




}
