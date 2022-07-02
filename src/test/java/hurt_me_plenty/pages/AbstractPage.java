package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public abstract class AbstractPage {
    WebDriver driver;
    WebDriverWait wait;

    public AbstractPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver switchToWindow() {
        String currentWindow;
        String windowToSwitch = null;
        currentWindow = driver.getWindowHandle();
        Set<String> currentWindows = driver.getWindowHandles();
        for (String window : currentWindows) {
            if (!window.equals(currentWindow)) {
                windowToSwitch = window;
                break;
            }
        }
        return driver.switchTo().window(windowToSwitch);
    }

    public WebDriver openNewWindow() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open()");
        return switchToWindow();
    }
    public WebDriver switchToIframe(){
        return driver.switchTo().frame(0).switchTo().frame("myFrame");
    }
}
//WebElement frame = driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]"));