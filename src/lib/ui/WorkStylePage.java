package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WorkStylePage extends BasePageObject {
    private static final String TITLE = "textViewTitle",
            IMAGE_TO_CLICK="android.widget.ImageView";

    public WorkStylePage(AppiumDriver driver) {
        super(driver);
    }

    /*
      basePage.waitForElementPresentBy(
                By.id(title),
                "Can not click next button",
                5
        );

        //  text Which outfits would you wear to work?

        assertEquals(
                basePage.waitForElementAndGetAttribute(By.id(title)
                        , "text",
                        "No title found",
                        5),
                "Which outfits would you wear to work?");

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
