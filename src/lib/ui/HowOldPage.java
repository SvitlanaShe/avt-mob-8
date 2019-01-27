package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HowOldPage extends BasePageObject {
    public static final String
            ITEM_TO_SELECT = "textViewDescription";

    public HowOldPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectAge() {
        waitForElementPresentByAndClick(
                By.id(ITEM_TO_SELECT),
                "Can not find age image",
                10);
    }
}
