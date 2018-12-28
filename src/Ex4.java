import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex4 {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\svitlana.shepotilova.PS-1142-PC\\AndroidStudioProjects\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.00.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void ex4VerifyTextPresentInSearchResultsList() {
        String text = "App";
        By by = By.xpath("//*[@text='Search and read the free encyclopedia in your language']");
        By listOfElementsBy = By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']");
        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);
        waitForElementPresentBy(by, "Text not found.", 5);
        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);
        List<WebElement> listOfElements = driver.findElements(listOfElementsBy);
        System.out.println(listOfElements.size());
        Assert.assertTrue("No searh results for the word '" + text + "'", listOfElements.size() > 0);
        listOfElements.forEach((searchResult) -> System.out.println(searchResult.getText() + "; "));
        listOfElements.forEach((searchResult) -> {
            Assert.assertTrue("Text " + text + " was not fount in sentence " + searchResult.getText(), searchResult.getText().contains(text));
        });
    }

    private WebElement waitForElementPresentBy(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresentByAndClick(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresentBy(by, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementPresentByAndSendKeys(By by, String keys, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresentBy(by, errorMessage, timeoutInSeconds);
        element.sendKeys(keys);
        return element;
    }

}
