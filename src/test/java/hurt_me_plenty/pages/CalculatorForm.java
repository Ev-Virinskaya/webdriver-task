package hurt_me_plenty.pages;

import hurt_me_plenty.content.RegData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorForm extends AbstractPage {
    private static final String LOCATOR_PATTERN = "//*[@id='select_container_%s']//*[contains(text(),'%s')]";

    public static final String OS_PART_ID = "99";

    public static final String VM_CLASS_PART_ID = "103";

    public static final String SERIES_PART_ID = "111";

    public static final String INSTANCE_TYPE_PART_ID = "113";

    public static final String GPU_TYPE_PART_ID = "457";

    public static final String NUMBER_OF_GPU_PART_ID = "459";

    public static final String LOCAL_SSD_PART_ID = "414";

    public static final String REGION_PART_ID = "119";

    public static final String USAGE_PART_ID = "126";


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
    private WebElement addEstimateButton;


    public ResultPage fillFields() {
        computeEngine.click();
        input.sendKeys(RegData.NUMBER_OF_INSTANCE);
        fillField(softwareField, OS_PART_ID, RegData.OS_TYPE);
        fillField(VMClassField, VM_CLASS_PART_ID, RegData.VM_CLASS);
        fillField(seriesField, SERIES_PART_ID, RegData.SERIES);
        fillField(instanceType, INSTANCE_TYPE_PART_ID, RegData.INSTANCE_TYPE);
        wait.until(ExpectedConditions.elementToBeClickable(addGPUCheckbox)).click();
        fillField(GPUTypeField, GPU_TYPE_PART_ID, RegData.GPU_TYPE);
        fillField(numberOfGPUField, NUMBER_OF_GPU_PART_ID, RegData.GPU_NUMBER);
        fillField(localSSDField, LOCAL_SSD_PART_ID, RegData.LOCAL_SSD);
        fillField(regionField, REGION_PART_ID, RegData.REGION);
        fillField(usageField, USAGE_PART_ID, RegData.COMMITMENT_TERM);
        addEstimateButton.click();

        return new ResultPage(driver, wait);
    }

    private String buildLocator(String idSelectContainer, String content) {
        return String.format(LOCATOR_PATTERN, idSelectContainer, content);
    }

    private void fillField(WebElement field, String partIdContainer, String content) {
        wait.until(ExpectedConditions.elementToBeClickable(field)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(buildLocator(partIdContainer, content))))).click();
    }


}
