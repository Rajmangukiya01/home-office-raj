package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(id = "response-0")
    WebElement lessThanSixMonths;

    @CacheLookup
    @FindBy(id = "response-1")
    WebElement moreThanSixMonths;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;


    public void selectLengthOfStay(String moreOrLess) {

        switch (moreOrLess) {
            case "longer than 6 months":
                clickOnElement(moreThanSixMonths);
                break;
            case "6 months or less":
                clickOnElement(lessThanSixMonths);
                break;
        }
    }

    public void clickNextStepButton() {
        clickOnElement(nextStepButton);
    }
}
