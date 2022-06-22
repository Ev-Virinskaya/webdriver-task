package hurt_me_plenty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage{
    //private String iframeLocator = "//*[@id='cloud-site']//iframe";
    //private String destinationIframeLocator = "//*[@id='myFrame']";


    public CalculatorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
    }

    public CalculatorForm switchCalcForm(){
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        return new CalculatorForm(driver, wait);
    }

}
