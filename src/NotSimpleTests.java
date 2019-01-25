
import lib.CoreTestCase;
import lib.ui.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

public class NotSimpleTests extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        String text = "Java";

        MainPageObject.waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        MainPageObject.waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        MainPageObject.waitForElementPresentBy(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_l ist_item_container']//*[@text='Object-oriented programming language']"),
                "Can not find article -  not found",
                15);

        driver.runAppInBackground(2);

        MainPageObject.waitForElementPresentBy(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Can not find article after returning from background",
                15);
    }

    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        String text = "Java";

        MainPageObject.waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        MainPageObject.waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Text title 'Object-oriented programming language' not found by " + text,
                15);

        String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "No title of article found",
                5);

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "No title of article found",
                5);
        Assert.assertEquals("Title is not similar when rotated", title_before_rotation, title_after_rotation);

        driver.rotate(ScreenOrientation.PORTRAIT);
        String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "No title of article found",
                5);
        Assert.assertEquals("Title is not similar when rotated", title_before_rotation, title_after_second_rotation);

    }

    @Test
    public void testAmountOfEmptySearch() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        String searchLine = "Linkin Park Diskography";
        searchPageObject.typeSearchLine(searchLine);

        String text = "yyhfcrv76vryfybbgy";

        MainPageObject.waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        MainPageObject.waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                15);

        String empty_result_label = "//*[@text='No results found']";
        String text_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        MainPageObject.waitForElementPresentBy(By.xpath(empty_result_label), "No element present", 5);
        MainPageObject.assertElementNotPresent(By.xpath(text_locator), "Text " + text + " should be not found");
    }

    @Test
    public void testAmountOfNotEmptySearch() {
        String searchLine = "Linkin Park Discography";

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);

//        MainPageObject.waitForElementPresentByAndClick(
//                By.className("android.widget.TextView"),
//                "Text element not found",
//                5);
//
//        MainPageObject.waitForElementPresentByAndSendKeys(
//                By.className("android.widget.EditText"),
//                searchLine,
//                "Edit text input not found",
//                5);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        MainPageObject.waitForElementPresentBy(
                By.xpath(search_result_locator),
                "Page title was not found " + searchLine,
                10);
        int amountOfSearchResult = MainPageObject.getAmountOfElements(By.xpath(search_result_locator));
        Assert.assertTrue("Search result is empty!", amountOfSearchResult > 0);
    }


    @Test
    @Ignore
    public void testSwipeArticleTest() {
        String text = "Appium";
//        By listOfElementsBy = By.xpath("//android.widget.TextView[contains(@text,'" + text + "')]");

        MainPageObject.waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        MainPageObject.waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "Page title was not found",
                5);
        MainPageObject.waitForElementPresentBy(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Page title was not found",
                15);

        MainPageObject.swipeUpToElementPresent(By.xpath("//*[@text='View page in browser']"), "Cant find text", 8);
    }

}
