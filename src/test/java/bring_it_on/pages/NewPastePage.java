package bring_it_on.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NewPastePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String titlePageLocator = "h1";
    private static final String textFieldLocator = "//div[@class='source']/ol/li";
    private static  final String formatLocator = "//div[@class='left']/a";

    public NewPastePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getTitlePage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(titlePageLocator))).getText();
    }

    public String getCodeText(){
        List<WebElement> text = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(textFieldLocator)));
        StringBuilder builder = new StringBuilder();
        for (WebElement string : text) {
            builder.append(string.getText()).append("\n");
        }
        return builder.toString().trim();
    }

    public String getFormat(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(formatLocator))).getText();
    }
}
