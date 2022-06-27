package hurt_me_plenty;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsSwitcher {

    private static String currentWindow;
    private static String windowToSwitch;


    public static WebDriver switchWindow(WebDriver driver){
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

    public static WebDriver openNewWindow(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open()");
        return switchWindow(driver);
    }
}
