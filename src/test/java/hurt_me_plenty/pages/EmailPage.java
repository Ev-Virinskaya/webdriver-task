package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EmailPage extends AbstractPage {
    private static final String REFRESH_BUTTON = "//*[@id='refresh']";
    private static final String FULL_IFRAME = "//iframe[@id='ifmail' and @state='full']";
    private static final String ESTIMATE_COST = "//td[@colspan='3']/following-sibling::td/h3";

    public EmailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private void refreshEmailBox() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REFRESH_BUTTON))).click();
    }

    public String getEstimateCost() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        refreshEmailBox();
        WebElement iframeIfmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FULL_IFRAME)));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeIfmail));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ESTIMATE_COST))).getText();

    }
}
