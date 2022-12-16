package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.WeakHashMap;

public class WorkTypePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//label[@class='gem-c-label govuk-label govuk-radios__label']")
    WebElement selectJobTypeList;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You need a visa to work in health and care')]")
    WebElement expectedMsg;


    public void selectJobType(String job) {
        if (selectJobTypeList.getText().equals(job)) {
            selectJobTypeList.click();
            System.out.println(selectJobTypeList.getText());
        }
    }

    public void clickNextStepButton() {
        clickOnElement(nextStepButton);
    }

    public String getActualMessage() {
        return getTextFromElement(expectedMsg);
    }
}
