package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends AbstractPage {
    private final String locator;
    private final String patternLocator = "//div[@class='gsc-thumbnail-inside']//b[text()='%s']/..";


    public SearchResultPage(WebDriver driver, WebDriverWait wait, String request) {
        super(driver, wait);
        this.locator = String.format(patternLocator, request);
    }

    public CalculatorPage openCalculatorPage() {
        findRelevantResponse().click();

        return new CalculatorPage(driver, wait);
    }

    private WebElement findRelevantResponse() {
        List<WebElement> relevantResponses = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
        if (relevantResponses.isEmpty()) {
            return new HomePageCloud(driver, wait).openPage().searchInfo().findRelevantResponse();
        } else {
            return relevantResponses.get(0);
        }
    }

}
