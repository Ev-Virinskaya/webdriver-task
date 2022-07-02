package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage extends AbstractPage {
    private final String elementToFindLocator;
    private final static String ELEMENT_COMMON_SEARCH_RESULT_LOCATOR = "//a[@class='gs-title']";
    private final static String PATTERN_LOCATOR = "%s/b[text()='%s']/..";


    public SearchResultPage(WebDriver driver, WebDriverWait wait, String request) {
        super(driver, wait);
        this.elementToFindLocator = String.format(PATTERN_LOCATOR, ELEMENT_COMMON_SEARCH_RESULT_LOCATOR, request);
    }

    public CalculatorPage openCalculatorPage() {
        findRelevantResponse().click();

        return new CalculatorPage(driver, wait);
    }

    private WebElement findRelevantResponse(){
        wait.pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ELEMENT_COMMON_SEARCH_RESULT_LOCATOR)));
        List<WebElement> relevantResponses = driver.findElements(By.xpath(elementToFindLocator));
        if (relevantResponses == null||relevantResponses.isEmpty()) {
            return new HomePageCloud(driver, wait).openPage().searchInfo().findRelevantResponse();
        } else {
            System.out.println(relevantResponses.size() + " : размер списка");
            return relevantResponses.get(0);
        }
    }

}
