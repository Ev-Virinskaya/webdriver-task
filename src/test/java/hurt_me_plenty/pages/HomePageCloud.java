package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageCloud extends AbstractPage{
    private static final String HOME_PAGE = "https://cloud.google.com/";
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String SEARCH_INPUT = "//input[@name='q']";


    public HomePageCloud(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomePageCloud openPage() {
        driver.get(HOME_PAGE);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return this;
    }

    public SearchResultPage searchInfo() {
        WebElement element = driver.findElement(By.xpath(SEARCH_INPUT));
        element.click();
        element.sendKeys(SEARCH_REQUEST, Keys.ENTER);
        return new SearchResultPage(driver, wait, SEARCH_REQUEST);
    }

}
