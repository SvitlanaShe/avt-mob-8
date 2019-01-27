package lib.ui;

import io.appium.java_client.AppiumDriver;

public class ShoeStylePage extends BasePageObject {
    private static final String LOGO = "imageViewLogo",
            buttonGetStarted = "",
            buttonLogin = "",
            textViewOotw = "";

    public ShoeStylePage(AppiumDriver driver) {
        super(driver);
    }
    /*
           basePage.waitForElementPresentBy(
                By.id("textViewTitle"),
                "Can not click next button",
                15
        );

        assertEquals(
                basePage.waitForElementAndGetAttribute(By.id("textViewTitle")
                        , "text",
                        "No title found",
                        5),
                "Which shoe styles do you like?");

        basePage.waitForElementPresentByAndClick(
                By.className("android.widget.ImageView"),
                "Can not find image",
                5);

        basePage.swipeUpToElementPresent(
                By.id("buttonNext"),
                "Can not find next button",
                3);

        basePage.waitForElementPresentByAndClick(
                By.id("buttonNext"),
                "Can not click next button",
                5);
     */
}
