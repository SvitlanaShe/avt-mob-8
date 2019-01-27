package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BrandsLikePage extends BasePageObject {
    public static final String
            ADDITIONAL_INFO_TEXT = "textInputEditTextAdditionalInfo";

    public BrandsLikePage(AppiumDriver driver) {
        super(driver);
    }

    public void typeMessageToStylist(String message_concerning_brands) {

        swipeUpToElementPresent(
                By.id(ADDITIONAL_INFO_TEXT),
                "Can not find text field",
                3);

        waitForElementPresentByAndSendKeys(
                By.id(ADDITIONAL_INFO_TEXT),
                message_concerning_brands,
                "Can not type in input for text",
                3);

        driver.hideKeyboard();
    }
}
