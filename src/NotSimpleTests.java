import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NotSimpleTests {

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
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        String text = "Java";

        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        waitForElementPresentBy(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Can not find article -  not found",
                15);

        driver.runAppInBackground(2);

        waitForElementPresentBy(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Can not find article after returning from background",
                15);
    }

    @Test
    @Ignore
    public void testChangeScreenOrientationOnSearchResults() {
        String text = "Java";

        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Text title 'Object-oriented programming language' not found by " + text,
                15);

        String title_before_rotation = waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "No title of article found",
                5);

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "No title of article found",
                5);
        Assert.assertEquals("Title is not similar when rotated",title_before_rotation,title_after_rotation);

        driver.rotate(ScreenOrientation.PORTRAIT);
        String title_after_second_rotation = waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "No title of article found",
                5);
        Assert.assertEquals("Title is not similar when rotated",title_before_rotation,title_after_second_rotation);

    }

    @Test
    @Ignore
    public void testAmountOfEmptySearch() {
        String text = "yyhfcrv76vryfybbgy";

        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                15);

        String empty_result_label = "//*[@text='No results found']";
        String text_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        waitForElementPresentBy(By.xpath(empty_result_label), "No element present", 5);
        assertElementNotPresent(By.xpath(text_locator), "Text " + text + " should be not found");
    }

    @Test
    @Ignore
    public void testAmountOfNotEmptySearch() {
        String text = "Linkin Park Discography";

        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        waitForElementPresentBy(
                By.xpath(search_result_locator),
                "Page title was not found",
                10);
        Assert.assertTrue("Search result is empty!", getAmountOfElements(By.xpath(search_result_locator)) > 0);

    }


    @Test
    @Ignore
    public void swipeArticleTest() {
        String text = "Appium";
//        By listOfElementsBy = By.xpath("//android.widget.TextView[contains(@text,'" + text + "')]");

        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "Page title was not found",
                5);
        waitForElementPresentBy(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Page title was not found",
                15);

        swipeUpToElementPresent(By.xpath("//*[@text='View page in browser']"), "Cant find text", 8);
    }

    @Test
    @Ignore
    public void saveFirstArticleToMyList() {
        String text = "Java";

        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Page title was not found",
                15);
        waitForElementPresentBy(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Page title was not found",
                15);
        waitForElementPresentByAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Button More options was not found",
                5);
        //Add to reading list
        waitForElementPresentByAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Add to reading list menu was not found",
                5);
        //org.wikipedia:id/onboarding_button
        waitForElementPresentByAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Add to reading list menu was not found",
                5);
        waitForElementPresentByAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Can not clear input field 'My reading list'",
                5);
        String articleName = "Learning programming";
        waitForElementPresentByAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                articleName,
                "Edit text input not found",
                5);
//android:id/button1
        waitForElementPresentByAndClick(
                By.xpath("//*[@text='OK']"),
                "Ok button not found",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Can not close an article. X was not found",
                5);
        //My lists

        waitForElementPresentByAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Can not find My list button",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@text='" + articleName + "']"),
                "Can not find title of article",
                15);

        swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Can not swipe article");

        waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Article is not deleted",
                5);

    }


    private boolean waitForElementNotPresent(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
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

    private WebElement waitForElementPresentByAndClear(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresentBy(by, errorMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeUp(int timeOfSwipe) {
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

    protected void swipeUpQuik() {
        swipeUp(200);
    }

    protected void swipeUpToElementPresent(By by, String errorMessage, int max_swiped) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swiped) {
                waitForElementPresentBy(by, "Cant find element while swipe " + errorMessage, 5);
            }
            System.out.println("Swipe!" + already_swiped++);
            swipeUpQuik();

        }
    }

    protected void swipeElementToLeft(By by, String errorMessage) {
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

    private int getAmountOfElements(By by) {
        return driver.findElements(by).size();
    }

    protected void assertElementNotPresent(By by, String errorMessage) {
        Assert.assertTrue(errorMessage + " Element found " + by, getAmountOfElements(by) == 0);
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String erorMessage, int time) {
        WebElement element = waitForElementPresentBy(by, erorMessage, time);
        return element.getAttribute(attribute);
    }
}
