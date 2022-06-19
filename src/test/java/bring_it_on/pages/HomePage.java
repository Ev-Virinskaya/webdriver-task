package pages;

import constants.RegistrationContent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private final String HOME_PAGE = "https://pastebin.com";

    private String locatorTemplate = "//li[text()='%s']";


    @FindBy(id = "postform-text")
    private WebElement codeContent;
    @FindBy(id = "select2-postform-format-container")
    private WebElement containerFormat;
//    @FindBy(xpath = "//li[text()='Bash']")
//    private WebElement format;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement containerExpiration;
//    @FindBy(xpath = "//li[text()='10 Minutes']")
//    private WebElement resultExpiration;
    @FindBy(id = "postform-name")
    private WebElement pasteName;
    @FindBy(xpath = "//div[@class='form-group form-btn-container']/button")
    private WebElement button;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.get(HOME_PAGE);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return this;
    }

    private void fillFields(){
        codeContent.sendKeys(RegistrationContent.CODE_CONTENT.getRegContent());
        containerFormat.click();
        chooseParam(RegistrationContent.FORMAT, locatorTemplate);
        containerExpiration.click();
        chooseParam(RegistrationContent.EXPIRATION, locatorTemplate);
        pasteName.sendKeys(RegistrationContent.PASTE_NAME.getRegContent());
    }

    private void chooseParam(RegistrationContent content, String locatorTemplate){
        driver.findElement(By.xpath(buildLocator(locatorTemplate, content))).click();
    }

    public pages.NewPaste createPastePage(){
        fillFields();
        button.click();
        return new pages.NewPaste(driver);

    }
    private String buildLocator(String locatorTemplate, RegistrationContent content){
        return String.format(locatorTemplate, content.getRegContent());
    }
}