package hurt_me_plenty.pages;

import hurt_me_plenty.content.RegData;
import hurt_me_plenty.content.PartIdSelectContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorForm extends AbstractPage{


    public CalculatorForm(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private String computeEngineLocator = "//md-tab-item/div[@title='Compute Engine']";
    private String inputLocator = "//*[@id='input_85']";
    private String softwareFieldLocator = "//*[@id='select_value_label_77']";
    private String VMClassLocator = "//*[@id='select_value_label_78']";
    private String seriesFieldLocator = "//*[@id='select_value_label_80']";
    private String instanceTypeLocator = "//*[@id='select_value_label_81']";
    private String addGPUCheckboxLocator = "//form[@name='ComputeEngineForm']//*[@aria-label='Add GPUs']";
    private String GPUTypeFieldLocator = "//md-select[@aria-label='GPU type']";
    private String numberOfGPUFieldLocator = "//md-select[@placeholder='Number of GPUs']";
    private String localSSDFieldLocator = "//*[@id='select_value_label_412']";
    private String regionFieldLocator = "//*[@id='select_value_label_83']";
    private String usageFieldLocator = "//*[@id='select_value_label_84']";
    private String buttonLocator = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']";



    private String buildLocator(String idSelectContainer, String content){
        return String.format("//*[@id='select_container_%s']//*[contains(text(),'%s')]",idSelectContainer, content);
    }

    public PageResult fillFields(){
        driver.findElement(By.xpath(computeEngineLocator)).click();
        driver.findElement(By.xpath(inputLocator)).sendKeys(RegData.NUMBER_OF_INSTANCE);
        fillField(softwareFieldLocator, PartIdSelectContainer.OS, RegData.OS_TYPE);
        fillField(VMClassLocator, PartIdSelectContainer.VM_CLASS, RegData.VM_CLASS);
        fillField(seriesFieldLocator, PartIdSelectContainer.SERIES, RegData.SERIES);
        fillField(instanceTypeLocator, PartIdSelectContainer.INSTANCE_TYPE, RegData.INSTANCE_TYPE);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addGPUCheckboxLocator))).click();
        fillField(GPUTypeFieldLocator, PartIdSelectContainer.GPU_TYPE, RegData.GPU_TYPE);
        fillField(numberOfGPUFieldLocator, PartIdSelectContainer.NUMBER_OF_GPU, RegData.GPU_NUMBER);
        fillField(localSSDFieldLocator, PartIdSelectContainer.LOCAL_SSD, RegData.LOCAL_SSD);
        fillField(regionFieldLocator, PartIdSelectContainer.REGION, RegData.REGION);
        fillField(usageFieldLocator, PartIdSelectContainer.USAGE, RegData.COMMITMENT_TERM);
        driver.findElement(By.xpath(buttonLocator)).click();

        return new PageResult(driver,wait);

    }

    private void fillField(String fieldLocator, String partIdContainer, String content){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fieldLocator))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(buildLocator(partIdContainer, content))))).click();
    }





}
