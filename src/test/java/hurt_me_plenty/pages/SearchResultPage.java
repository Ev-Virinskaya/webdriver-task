package hurt_me_plenty.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends AbstractPage {
    private final String locator;


    public SearchResultPage(WebDriver driver, WebDriverWait wait, String request) {
        super(driver, wait);
        this.locator = String.format("//div[@class='gsc-thumbnail-inside']//b[text()='%s']/..", request);
    }

    public CalculatorPage openCalculatorPage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();

        return new CalculatorPage(driver, wait);
    }

}
