package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//label[@class='gem-c-label govuk-label govuk-radios__label']")
    WebElement reasonForVisitList;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You will not need a visa to come to the UK')]")
    WebElement actualMessage;


    public void selectReasonForVisit(String reason) {
        List<WebElement> reasonForVisitList = driver.findElements(By.xpath("//label[@class='gem-c-label govuk-label govuk-radios__label']"));
        for (WebElement options : reasonForVisitList) {
            if (options.getText().equals(reason)) {
                options.click();
                System.out.println(options.getText());
            }
        }
    }

    public void clickNextStepButton() {
        clickOnElement(nextStepButton);
    }

    public String actualMessage() {
        return getTextFromElement(actualMessage);
    }
}
