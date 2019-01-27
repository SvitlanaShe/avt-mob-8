package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class RegistrationPage extends BasePageObject {
    private static final String
            TITLE = "android.widget.TextView",
            FIRST_NAME = "textInputEditTextFirstName",
            LAST_NAME = "textInputEditTextLastName",
            EMAIL = "textInputEditTextEmail",
            PASSWORD = "textInputEditTextPassword",
            FACEBOOK_BUTTON = "buttonFacebook",
            SUBSCRIPTION = "checkboxSubscription",
            TERMS_AND_CONDITIONS = "checkboxTermsAndConditions",
            REGISTRATION_BUTTON = "buttonRegister";

    public RegistrationPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void verifyTitle(String title) {
        waitForElementPresentBy(
                By.className(TITLE),
                "Can not find title ",
                5
        );
        assertEquals(
                waitForElementAndGetAttribute(By.className(TITLE)
                        , "text",
                        "Title is  not as expected!",
                        5),
                title);
    }

    public void typeInFirstName(String firstName) {
        waitForElementPresentByAndSendKeys(
                By.id(FIRST_NAME),
                firstName,
                "Can not find input for FirstName text",
                3);
        driver.hideKeyboard();

    }

    public void typeInLastName(String lastName) {
        waitForElementPresentByAndSendKeys(
                By.id(LAST_NAME),
                lastName,
                "Can not find input for FirstName text",
                3);

        driver.hideKeyboard();
    }

    public void typeInEmail() {
        SimpleDateFormat timestamp = new SimpleDateFormat("yyMMddHHmmss");
        String date = timestamp.format(new Date());
        String emailValue = "application.test+" + date + "@outfittery.de";

        waitForElementPresentByAndSendKeys(
                By.id(EMAIL),
                emailValue,
                "Can not find and type in input for email text",
                3);
        driver.hideKeyboard();
    }

    public void typeInPassword(String password) {
        waitForElementPresentByAndSendKeys(
                By.id(PASSWORD),
                password,
                "Can not find input for password text",
                3);

        driver.hideKeyboard();
    }

    public void checkTernsAndConditions() {
        swipeUpToElementPresent(
                By.id(TERMS_AND_CONDITIONS),
                "Can not find checkboxTermsAndConditions",
                3);

        waitForElementPresentByAndClick(
                By.id(TERMS_AND_CONDITIONS),
                "Can not click terms and condittions checkbox",
                5);
    }

    public void checkSubscription() {
        waitForElementPresentByAndClick(
                By.id(SUBSCRIPTION),
                "Can not click subscription checkbox",
                5);
    }

    public void gotToFacebookButton() {
        swipeUpToElementPresent(
                By.id(FACEBOOK_BUTTON),
                "Can not find Facebook button",
                3);

    }

    public void clickRegisterButton() {

        swipeUpToElementPresent(
                By.id(REGISTRATION_BUTTON),
                "Can not find register button",
                3);

        waitForElementPresentByAndClick(
                By.id(REGISTRATION_BUTTON),
                "Can not click register button",
                15);

    }
}
