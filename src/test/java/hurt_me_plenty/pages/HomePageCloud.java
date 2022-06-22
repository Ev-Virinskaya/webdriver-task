package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageCloud extends AbstractPage{
    private final String HOME_PAGE = "https://cloud.google.com/";
    private String searchTerm;
    private String searchInput = "//input[@name='q']";


    public HomePageCloud(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.searchTerm = "Google Cloud Platform Pricing Calculator";
    }

    public HomePageCloud openPage() {
        driver.get(HOME_PAGE);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return this;
    }

    public SearchResultPage searchInfo() {
        WebElement element = driver.findElement(By.xpath(searchInput));
        element.click();
        element.sendKeys(searchTerm, Keys.ENTER);
        return new SearchResultPage(driver, wait, searchTerm);
    }

}
