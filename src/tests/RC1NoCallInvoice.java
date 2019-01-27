package tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

public class RC1NoCallInvoice extends CoreTestCase {

    private BasePageObject basePage;

    protected void setUp() throws Exception {
        super.setUp();
        basePage = new BasePageObject(driver);
    }

    @Test
    public void testCheckPageInBackground() {

        MainPage main = new MainPage(driver);
        //go to staging
        main.clickOnLogo();
        main.clickOnGetStartedButton();

        TellAboutPage tellAboutPage = new TellAboutPage(driver);
        tellAboutPage.verifyTitle("Tell us about yourself");
        tellAboutPage.verifyDescription("Answer a few questions about your style, sizes, and budget and we will match you to the right stylist.");
        tellAboutPage.clickOnSkipButton();


//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonGetStarted"),
//                "Get started button not found",
//                5);

//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonSkip"),
//                "Skip button not found",
//                5);
//leisure page
        LeasurePage leasurePage = new LeasurePage(driver);
        leasurePage.verifyTitle("Which leisure outfits do you like?");

//        basePage.waitForElementPresentBy(
//                By.id("textViewTitle"),
//                "Can not click next button",
//                15
//        );
//        //  text Which leisure outfits do you like?
//
//        assertEquals(
//                basePage.waitForElementAndGetAttribute(By.id("textViewTitle")
//                        , "text",
//                        "No title found",
//                        5),
//                "Which leisure outfits do you like?");

        leasurePage.selectItem();

//        basePage.waitForElementPresentByAndClick(
//                By.className("android.widget.ImageView"),
//                "Can not find image",
//                15);

        leasurePage.clickOnNextButton();

//        basePage.swipeUpToElementPresent(
//                By.id("buttonNext"),
//                "Can not find next button",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonNext"),
//                "Can not click next button",
//                15);

        //workstyle

        WorkStylePage workStylePage = new WorkStylePage(driver);
        workStylePage.verifyTitle("Which outfits would you wear to work?");
        workStylePage.selectItem();
        workStylePage.clickOnNextButton();

//        basePage.waitForElementPresentBy(
//                By.id("textViewTitle"),
//                "Can not click next button",
//                15
//        );
//
//        //  text Which outfits would you wear to work?
//
//        assertEquals(
//                basePage.waitForElementAndGetAttribute(By.id("textViewTitle")
//                        , "text",
//                        "No title found",
//                        5),
//                "Which outfits would you wear to work?");
//
//        basePage.waitForElementPresentByAndClick(
//                By.className("android.widget.ImageView"),
//                "Can not find image",
//                15);
//
//        basePage.swipeUpToElementPresent(
//                By.id("buttonNext"),
//                "Can not find next button",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonNext"),
//                "Can not click next button",
//                15);

        // shoe styles
//        basePage.waitForElementPresentBy(
//                By.id("textViewTitle"),
//                "Can not click next button",
//                15
//        );
//
//        assertEquals(
//                basePage.waitForElementAndGetAttribute(By.id("textViewTitle")
//                        , "text",
//                        "No title found",
//                        5),
//                "Which shoe styles do you like?");
//
//        basePage.waitForElementPresentByAndClick(
//                By.className("android.widget.ImageView"),
//                "Can not find image",
//                15);
//
//        basePage.swipeUpToElementPresent(
//                By.id("buttonNext"),
//                "Can not find next button",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonNext"),
//                "Can not click next button",
//                15);
        ShoeStylePage shoeStylePage = new ShoeStylePage(driver);
        shoeStylePage.verifyTitle("Which shoe styles do you like?");
        shoeStylePage.selectItem();
        shoeStylePage.clickOnNextButton();

        // never wear
//        basePage.waitForElementPresentBy(
//                By.id("textViewTitle"),
//                "Can not click next button",
//                15
//        );
//
//        assertEquals(
//                basePage.waitForElementAndGetAttribute(By.id("textViewTitle")
//                        , "text",
//                        "No title found",
//                        5),
//                "What would you NEVER wear?");
//
//        basePage.waitForElementPresentByAndClick(
//                By.className("android.widget.ImageView"),
//                "Can not find image",
//                15);
//
//        basePage.swipeUpToElementPresent(
//                By.id("buttonNext"),
//                "Can not find next button",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonNext"),
//                "Can not click next button",
//                15);

        NeverWearPage neverWearPage = new NeverWearPage(driver);
        neverWearPage.verifyTitle("What would you NEVER wear?");
        neverWearPage.selectItem();
        neverWearPage.clickOnNextButton();

        // brands like

        BrandsLikePage brandsLikePage = new BrandsLikePage(driver);
        brandsLikePage.verifyTitle("Which brands do you like?");
        brandsLikePage.selectItem();
        brandsLikePage.typeMessageToStylist("Message concerning brands");
        brandsLikePage.clickOnNextButton();

//        basePage.waitForElementPresentBy(
//                By.id("textViewTitle"),
//                "Can not click next button",
//                15
//        );
//
//        assertEquals(
//                basePage.waitForElementAndGetAttribute(By.id("textViewTitle")
//                        , "text",
//                        "No title found",
//                        5),
//                "Which brands do you like?");
//
//        basePage.waitForElementPresentByAndClick(
//                By.className("android.widget.ImageView"),
//                "Can not find image",
//                15);

//
//        basePage.swipeUpToElementPresent(
//                By.id("textInputEditTextAdditionalInfo"),
//                "Can not find text field",
//                3);
//
//        basePage.waitForElementPresentByAndSendKeys(
//                By.id("textInputEditTextAdditionalInfo"),
//                "Message concerning brands",
//                "Can not find input for text",
//                3);
//
//        driver.hideKeyboard();

//        basePage.swipeUpToElementPresent(
//                By.id("buttonNext"),
//                "Can not find next button",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonNext"),
//                "Can not click next button",
//                15);


        // how old do you feel
        HowOldPage howOldPage = new HowOldPage(driver);
        howOldPage.verifyTitle("How old do you feel?");
        howOldPage.selectAge();
        howOldPage.clickOnNextButton();

//        basePage.waitForElementPresentByAndClick(
//                By.id("textViewDescription"),
//                "Can not find image",
//                15);

//        basePage.swipeUpToElementPresent(
//                By.id("buttonNext"),
//                "Can not find next button",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonNext"),
//                "Can not click next button",
//                15);

        // motivation
        MotivationPage motivationPage = new MotivationPage(driver);
        motivationPage.verifyTitle("What's motivating you to try out our service?");
        motivationPage.selectMotivation();
        motivationPage.clickOnNextButton();
//        basePage.waitForElementPresentBy(
//                By.id("textViewTitle"),
//                "Can not click next button",
//                15
//        );
//
//        assertEquals(
//                basePage.waitForElementAndGetAttribute(By.id("textViewTitle")
//                        , "text",
//                        "No title found",
//                        5),
//                "What's motivating you to try out our service?");

//        basePage.waitForElementPresentByAndClick(
//                By.id("textViewDescription"),
//                "Can not find image",
//                15);
//
//        basePage.swipeUpToElementPresent(
//                By.id("buttonNext"),
//                "Can not find next button",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonNext"),
//                "Can not click next button",
//                15);

        //registration page
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.verifyTitle("Sign up to save your profile");
        registrationPage.typeInFirstName("Test");
        registrationPage.typeInLastName("Mobile");
        registrationPage.typeInEmail();
        registrationPage.typeInPassword("application.test");
        registrationPage.checkTernsAndConditions();
        registrationPage.checkSubscription();
        registrationPage.gotToFacebookButton();
        registrationPage.clickRegisterButton();


        SizePage sizePage = new SizePage(driver);
        sizePage.selectHair();
        sizePage.selectShirtSize();
//        sizePage.selectTrousersWaist();
        sizePage.selectTrousersLength();
        sizePage.selectShoeSize();
        sizePage.selectTrousersWaist();
        sizePage.clickOnNextButton();

        BudgetPage budgetPage = new BudgetPage(driver);
        budgetPage.clickOnNextButton();

        KeyPiecesPage keyPiecesPage = new KeyPiecesPage(driver);
        keyPiecesPage.clickOnNextButton();

        JeansPage jeansPage = new JeansPage(driver);
        jeansPage.selectJeans();
        jeansPage.clickOnNextButton();

        OccasionPage occasionPage = new OccasionPage(driver);
//        occasionPage.selectOccasion();
//        occasionPage.typeMessageToStylist("Ocassion to stylist message");
        occasionPage.clickOnNextButton();

        WhatHappensNextPage whatHappensNextPage = new WhatHappensNextPage(driver);
        whatHappensNextPage.clickOnNextButton();

        AddressPage addressPage = new AddressPage(driver);
        addressPage.fillAllData();
//        addressPage.typeStreet("RiskCheckStrasse");
//        addressPage.typeInCity("TestCity");
//        addressPage.typeHouseNumber("1");
//        addressPage.typeZIP("12345");
//        addressPage.selectDateOfBirth("date");
//        addressPage.typeInVoucher("DIS10PEREUR");
//        addressPage.clickOnNextButton();

        FrequencyPage frequencyPage = new FrequencyPage(driver);
        frequencyPage.verifyTitle("Do you want regular updates to your wardrobe?");
        frequencyPage.verifyDescription("OUTFITTERY Autopilot - convenient updates to your wardrobe as often as you like. Choose now:");
        frequencyPage.selectFrequency();
        frequencyPage.clickOnNextButton();




//        assertEquals(
//                basePage.waitForElementAndGetAttribute(By.className("android.widget.TextView")
//                        , "text",
//                        "No title text found",
//                        5),
//                "Sign up to save your profile");

//        basePage.waitForElementPresentByAndSendKeys(
//                By.id("textInputEditTextFirstName"),
//                "Test",
//                "Can not find input for FirstName text",
//                3);
//        driver.hideKeyboard();
//
//        basePage.waitForElementPresentByAndSendKeys(
//                By.id("textInputEditTextLastName"),
//                "Mobile",
//                "Can not find input for FirstName text",
//                3);
//
//        driver.hideKeyboard();

//        SimpleDateFormat timestamp = new SimpleDateFormat("yyMMddHHmmss");
//        String date = timestamp.format(new Date());
//        String emailValue = "application.test+" + date + "@outfittery.de";
//
//        basePage.waitForElementPresentByAndSendKeys(
//                By.id("textInputEditTextEmail"),
//                emailValue,
//                "Can not find input for FirstName text",
//                3);
//        driver.hideKeyboard();
//
//        basePage.waitForElementPresentByAndSendKeys(
//                By.id("textInputEditTextPassword"),
//                "application.test",
//                "Can not find input for FirstName text",
//                3);
//
//        driver.hideKeyboard();

//        basePage.swipeUpToElementPresent(
//                By.id("checkboxTermsAndConditions"),
//                "Can not find checkboxTermsAndConditions",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("checkboxTermsAndConditions"),
//                "Can not click terms and condittions checkbox",
//                15);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("checkboxSubscription"),
//                "Can not click subscription checkbox",
//                15);
//
//        basePage.swipeUpToElementPresent(
//                By.id("buttonFacebook"),
//                "Can not find checkboxTermsAndConditions",
//                3);
//
//        basePage.swipeUpToElementPresent(
//                By.id("buttonRegister"),
//                "Can not find checkboxTermsAndConditions",
//                3);
//
//        basePage.waitForElementPresentByAndClick(
//                By.id("buttonRegister"),
//                "Can not click register button",
//                15);


//        driver.runAppInBackground(2);
//
//        basePage.waitForElementPresentBy(
////                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                By.className("android.widget.ImageView"),
//                "Can not find article after returning from background",
//                15);
    }
}
