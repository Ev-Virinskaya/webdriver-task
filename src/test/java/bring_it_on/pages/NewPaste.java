package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewPaste {
    private WebDriver driver;

    @FindBy(tagName = "h1")
    private WebElement titlePage;
    @FindBy(xpath = "//div[@class='source']/ol/li")
    private WebElement stringText;
    @FindBy(xpath = "//div[@class='left']/a")
    private WebElement syntax;

    public NewPaste(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitlePage(){
        return titlePage.getText();
    }

    public String getText(){
        List<WebElement> text = stringText.findElements(By.xpath("//div[@class='source']/ol/li"));
        StringBuilder builder = new StringBuilder();
        for (WebElement string : text) {
            builder.append(string.getText()).append("\n");
        }
        return builder.toString().trim();
    }

    public String getSyntax(){
        return syntax.getText();
    }
}
