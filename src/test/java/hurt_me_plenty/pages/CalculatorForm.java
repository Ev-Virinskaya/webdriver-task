package hurt_me_plenty.pages;

import hurt_me_plenty.content.RegData;
import hurt_me_plenty.content.PartIdSelectContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorForm extends AbstractPage {
    private String locatorPattern = "//*[@id='select_container_%s']//*[contains(text(),'%s')]";


    public CalculatorForm(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;
    @FindBy(xpath = "//*[@id='input_85']")
    private WebElement input;
    @FindBy(xpath = "//*[@id='select_value_label_77']")
    private WebElement softwareField;
    @FindBy(xpath = "//*[@id='select_value_label_78']")
    private WebElement VMClassField;
    @FindBy(xpath = "//*[@id='select_value_label_80']")
    private WebElement seriesField;
    @FindBy(xpath = "//*[@id='select_value_label_81']")
    private WebElement instanceType;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[@aria-label='Add GPUs']")
    private WebElement addGPUCheckbox;
    @FindBy(xpath = "//md-select[@aria-label='GPU type']")
    private WebElement GPUTypeField;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUField;
    @FindBy(xpath = "//*[@id='select_value_label_412']")
    private WebElement localSSDField;
    @FindBy(xpath = "//*[@id='select_value_label_83']")
    private WebElement regionField;
    @FindBy(xpath = "//*[@id='select_value_label_84']")
    private WebElement usageField;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement button;


    public PageResult fillFields() {
        computeEngine.click();
        input.sendKeys(RegData.NUMBER_OF_INSTANCE);
        fillField(softwareField, PartIdSelectContainer.OS, RegData.OS_TYPE);
        fillField(VMClassField, PartIdSelectContainer.VM_CLASS, RegData.VM_CLASS);
        fillField(seriesField, PartIdSelectContainer.SERIES, RegData.SERIES);
        fillField(instanceType, PartIdSelectContainer.INSTANCE_TYPE, RegData.INSTANCE_TYPE);
        wait.until(ExpectedConditions.elementToBeClickable(addGPUCheckbox)).click();
        fillField(GPUTypeField, PartIdSelectContainer.GPU_TYPE, RegData.GPU_TYPE);
        fillField(numberOfGPUField, PartIdSelectContainer.NUMBER_OF_GPU, RegData.GPU_NUMBER);
        fillField(localSSDField, PartIdSelectContainer.LOCAL_SSD, RegData.LOCAL_SSD);
        fillField(regionField, PartIdSelectContainer.REGION, RegData.REGION);
        fillField(usageField, PartIdSelectContainer.USAGE, RegData.COMMITMENT_TERM);
        button.click();

        return new PageResult(driver, wait);
    }

    private String buildLocator(String idSelectContainer, String content) {
        return String.format(locatorPattern, idSelectContainer, content);
    }

    private void fillField(WebElement field, String partIdContainer, String content) {
        wait.until(ExpectedConditions.elementToBeClickable(field)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(buildLocator(partIdContainer, content))))).click();
    }


}
