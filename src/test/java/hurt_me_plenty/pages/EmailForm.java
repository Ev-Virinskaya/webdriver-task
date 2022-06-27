package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class EmailForm extends AbstractPage {
    private final String emailInputLocator = "//input[@type='email']";
    private final String addressEmailGenerator = "";

    public EmailForm(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

//    public EmailPage getResultOnEmail() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']"))).sendKeys(createEmail());
//        driver.findElement(By.xpath("//button[@aria-label='Send Email']")).click();
//        driver = WindowsSwitcher.switchWindow(this);
//        return new EmailPage(driver, wait);
//    }
//
//    private String createEmail(){
//        driver = WindowsSwitcher.openNewWindow(this);
//        return new EmailGeneratorPage(driver,wait).generateEmailAddress();
//    }


    public EmailPage getEmailPage(){
        String currentWindow = driver.getWindowHandle();
        String windowToSwitch = null;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.open()");
        Set<String> currentWindows = driver.getWindowHandles();

        for (String window : currentWindows) {
            if (!window.equals(currentWindow)) {
                windowToSwitch = window;
                break;
            }
        }
        driver.switchTo().window(windowToSwitch);
        driver.get("https://yopmail.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='listeliens']/a[@href='email-generator']"))).click();
        String email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='egen']"))).getText();
        driver.switchTo().window(currentWindow);
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']"))).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Send Email']"))).click();
        driver.close();
        driver.switchTo().window(windowToSwitch);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@onclick='egengo();']"))).click();
        return new EmailPage(driver, wait);


    }


}
