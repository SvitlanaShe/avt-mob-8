import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
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

public class Ex4 extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testEx4VerifyTextPresentInSearchResultsList() {
        String text = "App";
        By by = By.xpath("//*[@text='Search and read the free encyclopedia in your language']");
        By listOfElementsBy = By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']");
        MainPageObject.waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);
        MainPageObject.waitForElementPresentBy(by, "Text not found.", 5);
        MainPageObject.waitForElementPresentByAndSendKeys(
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


}
