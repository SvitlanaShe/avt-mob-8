package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TellAboutPage extends BasePageObject {
    private static final String SKIP_BUTTON = "buttonSkip",
            IMAGE = "imageViewImage",
            TITLE = "textViewTitle",
            START_BUTTON = "buttonDone",
            DESCRIPTION = "textViewDescription";

    public TellAboutPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnSkipButton() {
        waitForElementPresentByAndClick(
                By.id(SKIP_BUTTON),
                "Skip button is not clicked!",
                15);
    }

    public void verifyDescription(String description) {
        String description_actual = waitForElementAndGetAttribute(
                By.id(DESCRIPTION),
                "text",
                "Descriprion is not present!",
                15
        );
        Assert.assertEquals("Description mismuch!", description, description_actual);
    }

    public void skipCurrentTitleAndDescription() {
        WebElement element = waitForElementPresentBy(By.id(TITLE), "Impossible to swipe to left!", 15);
        WebElement image = waitForElementPresentBy(By.id(DESCRIPTION), "Impossible to swipe to left!", 15);

        int left_x = image.getLocation().getX();
//        left_x=0;
//                left_x = driver.manage().window().getSize().width;
        int right_x = left_x + image.getSize().getWidth() + 50;
//        right_x = driver.manage().window().getSize().width;
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }

    public void clickOnStartButton() {
        waitForElementPresentByAndClick(
                By.id(START_BUTTON),
                "Can not find and click Start Button",
                5);
    }

    public void verifyNoSkipButton() {
        waitForElementNotPresent(
                By.id(SKIP_BUTTON),
                "Skip button still present! Should be Start button instead!",
                5
        );
    }
}
