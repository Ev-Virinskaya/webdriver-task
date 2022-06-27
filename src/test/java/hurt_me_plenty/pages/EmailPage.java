package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EmailPage extends AbstractPage {

    public EmailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private void refreshEmailBox() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='refresh']"))).click();
    }

    public String getEstimateCost() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        refreshEmailBox();
        WebElement iframeIfmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='ifmail' and @state='full']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeIfmail));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@colspan='3']/following-sibling::td/h3")));
        return element.getText();

    }
}
