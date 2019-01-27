package lib.ui;

import io.appium.java_client.AppiumDriver;

public class PostOrderOptionsPage extends BasePageObject {
    private static final String
            NO_THANKS = "//*[@text='No, thanks!']",
            ANY_FREQUENCY_CLASSNAME = "android.widget.RadioButton",
            EVERY_2_MONTHS = "//*[@text='Every 2 Months']";

    public PostOrderOptionsPage(AppiumDriver driver) {
        super(driver);
    }
}
