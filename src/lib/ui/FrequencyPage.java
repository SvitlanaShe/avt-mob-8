package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FrequencyPage extends BasePageObject {
    private static final String
            NO_THANKS = "//*[@text='No, thanks!']",
    ANY_FREQUENCY_CLASSNAME = "android.widget.RadioButton",
    EVERY_2_MONTHS = "//*[@text='Every 2 Months']";

    public FrequencyPage(AppiumDriver driver) {
        super(driver);
    }

    public void verifyDescription(String description) {
        //TODO implement
    }

    public void selectFrequency() {
        waitForElementPresentByAndClick(
                By.className(ANY_FREQUENCY_CLASSNAME),
                "No frequency checkbox found",
                5);
    }
}
