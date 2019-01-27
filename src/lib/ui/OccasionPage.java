package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OccasionPage extends BasePageObject {
    private static final String OCCASION_IMAGE = "cardView",
            TEXT_INPUT = "textInputEditTextAdditionalInfo";

    public OccasionPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectOccasion() {
        waitForElementPresentByAndClick(
                By.className(OCCASION_IMAGE),
                "Occasional image could not be found and clicked!",
                5);
    }

    public void typeMessageToStylist(String ocassion_to_stylist_message) {
        swipeUpToElementPresent(
                By.id(TEXT_INPUT),
                "Text input not found",
                5);
        waitForElementPresentByAndSendKeys(
                By.id(TEXT_INPUT),
                ocassion_to_stylist_message,
                "Can not type in message to stylist text box",
                5);
        driver.hideKeyboard();
    }
}
