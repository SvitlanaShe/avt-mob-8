package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AddressPage extends BasePageObject {
    private static final String FIRST_NAME = "textInputEditTextFirstName",
            LAST_NAME = "textInputEditTextLastName",
            STREET = "textInputLayoutStreet",
            HOUSE_NAMBER = "textInputEditTextStreetNumber",
            ZIPCODE = "textInputEditTextZip",
            CITY = "textInputEditTextCity",
            PHONE_NUMBER = "textInputEditTextPhoneNumber",
            DATE_OF_BIRTH = "textInputEditTextDatepicker",
            VOUCHER_CODE = "textInputEditTextVoucherCode",
    //calendar
    DATE = "//*[@text='10']",
            OK_BUTTON = "button1",
            CANCEL_BUTTON = "button2";

    public AddressPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectDateOfBirth(String date) {
        swipeUpToElementPresent(
                By.id(DATE_OF_BIRTH),
                "Date of birth field not found",
                5);
        waitForElementPresentByAndClick(
                By.id(DATE_OF_BIRTH),
                "Date of birth field not found and could not be clicked",
                5);
        waitForElementPresentByAndClick(
                By.xpath(DATE),
                "can not find date 10",
                5);
        waitForElementPresentByAndClick(
                By.id(OK_BUTTON),
                "OK button not found and can not be cicked",
                5);
        waitForElementPresentBy(
                By.id(DATE_OF_BIRTH),
                "Date of birthday field is not found!",
                5);
        driver.hideKeyboard();
    }

    public void typeStreet(String street) {
        swipeUpToElementPresent(
                By.id(STREET),
                "Street field not found",
                5);
        waitForElementPresentByAndSendKeys(
                By.id(STREET),
                street,
                "Street input not found",
                5);
        driver.hideKeyboard();
    }

    public void typeHouseNumber(String house_number) {
        swipeUpToElementPresent(
                By.id(HOUSE_NAMBER),
                "House number field not found",
                2);
        waitForElementPresentByAndSendKeys(
                By.id(HOUSE_NAMBER),
                house_number,
                "House number input not found",
                5);
        driver.hideKeyboard();
    }

    public void typeZIP(String zip) {
        swipeUpToElementPresent(
                By.id(ZIPCODE),
                "Zip field not found",
                5);
        waitForElementPresentByAndSendKeys(
                By.id(ZIPCODE),
                zip,
                "Zip input not found",
                5);
        driver.hideKeyboard();
    }

    public void typeInVoucher(String voucher) {
        swipeUpToElementPresent(
                By.id(VOUCHER_CODE),
                "Voucher code field not found",
                5);
        waitForElementPresentByAndSendKeys(
                By.id(VOUCHER_CODE),
                voucher,
                "Voucher input not found",
                5);
        driver.hideKeyboard();
    }
    public void typeInCity(String city) {
        swipeUpToElementPresent(
                By.id(CITY),
                "City field not found",
                5);
        waitForElementPresentByAndSendKeys(
                By.id(CITY),
                city,
                "City input not found",
                5);
        driver.hideKeyboard();
    }

    public void fillAllData() {
        typeStreet("RiskCheckStrasse");
        typeInCity("TestCity");
        typeHouseNumber("1");
        typeZIP("12345");
        selectDateOfBirth("date");
        typeInVoucher("DIS10PEREUR");
        clickOnNextButton();
    }
}
