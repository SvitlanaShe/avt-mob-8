package tests;

import lib.CoreTestCase;
import lib.ui.BasePageObject;
import lib.ui.LeasurePage;
import lib.ui.MainPage;
import lib.ui.TellAboutPage;
import org.junit.Test;

public class TellUsAbout extends CoreTestCase {
    private BasePageObject basePage;

    protected void setUp() throws Exception {
        super.setUp();
        basePage = new BasePageObject(driver);
    }

    @Test
    public void testProceedFirstSkip() {

        MainPage main = new MainPage(driver);
        //go to staging
        main.clickOnLogo();
        main.clickOnGetStartedButton();

        TellAboutPage tellAboutPage = new TellAboutPage(driver);
        tellAboutPage.verifyTitle("Tell us about yourself");
        tellAboutPage.verifyDescription("Answer a few questions about your style, sizes, and budget and we will match you to the right stylist.");
        tellAboutPage.skipCurrentTitleAndDescription();
        tellAboutPage.verifyTitle("Get selection of hand-picked clothes");
        tellAboutPage.verifyDescription("Your stylist will put together the perfect combination of clothes based on your preferences.");
        tellAboutPage.clickOnSkipButton();

        LeasurePage leasurePage = new LeasurePage(driver);
        leasurePage.verifyTitle("Which leisure outfits do you like?");
    }

    @Test
    public void testProceedSecondSkip() {

        MainPage main = new MainPage(driver);
        //go to staging
        main.clickOnLogo();
        main.clickOnGetStartedButton();

        TellAboutPage tellAboutPage = new TellAboutPage(driver);
        tellAboutPage.verifyTitle("Tell us about yourself");
        tellAboutPage.verifyDescription("Answer a few questions about your style, sizes, and budget and we will match you to the right stylist.");
        tellAboutPage.skipCurrentTitleAndDescription();
        tellAboutPage.verifyTitle("Get selection of hand-picked clothes");
        tellAboutPage.verifyDescription("Your stylist will put together the perfect combination of clothes based on your preferences.");
        tellAboutPage.skipCurrentTitleAndDescription();
        tellAboutPage.verifyTitle("Try on at home");
        tellAboutPage.verifyDescription("You have 7 days to try the items. Only pay for the items you keep. Shipping and return are free.");
        tellAboutPage.verifyNoSkipButton();
        tellAboutPage.clickOnStartButton();

        LeasurePage leasurePage = new LeasurePage(driver);
        leasurePage.verifyTitle("Which leisure outfits do you like?");
    }

    @Test
    public void testProceedNoSkip() {

        MainPage main = new MainPage(driver);
        //go to staging
        main.clickOnLogo();
        main.clickOnGetStartedButton();

        TellAboutPage tellAboutPage = new TellAboutPage(driver);
        tellAboutPage.verifyTitle("Tell us about yourself");
        tellAboutPage.verifyDescription("Answer a few questions about your style, sizes, and budget and we will match you to the right stylist.");
        tellAboutPage.clickOnSkipButton();

        LeasurePage leasurePage = new LeasurePage(driver);
        leasurePage.verifyTitle("Which leisure outfits do you like?");
    }
}
