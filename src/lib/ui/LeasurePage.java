package lib.ui;

import io.appium.java_client.AppiumDriver;

public class LeasurePage extends BasePageObject {

    private static final String title = "textViewTitle",
            IMAGE_TO_CLICK = "android.widget.ImageView";

    public LeasurePage(AppiumDriver driver){
        super(driver);
    }

//    public void verifyTitle(String expectedTitle){
//        waitForElementPresentBy(
//                By.id(title),
//                "Title is not present!",
//                15
//        );
//
//        Assert.assertEquals(
//                waitForElementAndGetAttribute(By.id(title)
//                        , "text",
//                        "No title found",
//                        5),
//                expectedTitle);
//    }

//    public void selectItem() {
//        waitForElementPresentByAndClick(
//                By.className(IMAGE_TO_CLICK),
//                "Can not find image",
//                5);
//    }
    /*


        basePage.waitForElementPresentByAndClick(
                By.className("android.widget.ImageView"),
                "Can not find image",
                15);

        basePage.swipeUpToElementPresent(
                By.id("buttonNext"),
                "Can not find next button",
                3);

        basePage.waitForElementPresentByAndClick(
                By.id("buttonNext"),
                "Can not click next button",
                15);
     */
}
