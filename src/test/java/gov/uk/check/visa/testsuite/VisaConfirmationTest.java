package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends BaseTest {
    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    DurationOfStayPage durationOfStayPage;
    WorkTypePage workTypePage;
    ResultPage resultPage;

    @BeforeMethod
    public void init() {
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        durationOfStayPage = new DurationOfStayPage();
        workTypePage = new WorkTypePage();
        resultPage = new ResultPage();
    }

    @Test
    public void anAustralianComingToUKForTourism() {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        reasonForTravelPage.clickNextStepButton();
        //Assert.assertEquals(reasonForTravelPage.actualMessage(), "You will not need a visa to come to the UK", "Message is not displayed");
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");
    }

    @Test
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Chile");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        reasonForTravelPage.clickNextStepButton();
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobType("Health and care professional");
        workTypePage.clickNextStepButton();
        //Assert.assertEquals(workTypePage.getActualMessage(), "You need a visa to work in health and care", "Message is not displayed");
        resultPage.confirmResultMessage("You need a visa to work in health and care");
    }

    @Test
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {

    }
}
