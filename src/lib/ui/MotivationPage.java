package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MotivationPage extends BasePageObject {
    private static final String ITEM_TO_SELECT = "textViewDescription";

    public MotivationPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectMotivation() {
        waitForElementPresentByAndClick(
                By.id(ITEM_TO_SELECT),
                "Can not find motivation image",
                10);
    }
}
