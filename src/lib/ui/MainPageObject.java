package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }


    public boolean waitForElementNotPresent(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementPresentBy(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresentBy(By by, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.withMessage(errorMessage);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresentByAndClick(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresentBy(by, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementPresentByAndSendKeys(By by, String keys, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresentBy(by, errorMessage, timeoutInSeconds);
        element.sendKeys(keys);
        return element;
    }

    public WebElement waitForElementPresentByAndClear(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresentBy(by, errorMessage, timeoutInSeconds);
        element.click();
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }

    public void swipeUpQuik() {
        swipeUp(200);
    }

    public void swipeUpToElementPresent(By by, String errorMessage, int max_swiped) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swiped) {
                waitForElementPresentBy(by, "Cant find element while swipe " + errorMessage, 5);
            }
            System.out.println("Swipe!" + already_swiped++);
            swipeUpQuik();

        }
    }

    public void swipeElementToLeft(By by, String errorMessage) {
        WebElement element = waitForElementPresentBy(by, errorMessage, 15);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
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

    public int getAmountOfElements(By by) {
        return driver.findElements(by).size();
    }

    public void assertElementNotPresent(By by, String errorMessage) {
        Assert.assertTrue(errorMessage + " Element found " + by, getAmountOfElements(by) == 0);
    }

    public String waitForElementAndGetAttribute(By by, String attribute, String erorMessage, int time) {
        WebElement element = waitForElementPresentBy(by, erorMessage, time);
        return element.getAttribute(attribute);
    }
}
