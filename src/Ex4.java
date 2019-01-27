import lib.CoreTestCase;
import lib.ui.BasePageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ex4 extends CoreTestCase {

    private BasePageObject BasePageObject;

    protected void setUp() throws Exception {
        super.setUp();
        BasePageObject = new BasePageObject(driver);
    }

    @Test
    public void testEx4VerifyTextPresentInSearchResultsList() {
        String text = "App";
        By by = By.xpath("//*[@text='Search and read the free encyclopedia in your language']");
        By listOfElementsBy = By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']");
        BasePageObject.waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);
        BasePageObject.waitForElementPresentBy(by, "Text not found.", 5);
        BasePageObject.waitForElementPresentByAndSendKeys(
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
