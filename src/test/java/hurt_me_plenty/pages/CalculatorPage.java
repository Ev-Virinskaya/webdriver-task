package hurt_me_plenty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage{

    public CalculatorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
    }

    public CalculatorForm switchCalcForm(){
        switchToIframe();
        return new CalculatorForm(driver, wait);
    }

}
