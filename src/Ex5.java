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
import java.util.concurrent.TimeUnit;

public class Ex5 {
    /*
    Написать тест, который:
1. Сохраняет две статьи в одну папку
2. Удаляет одну из статей
3. Убеждается, что вторая осталась
4. Переходит в неё и убеждается, что title совпадает
     */
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
    public void addTwoArticlesDeleteOneAndVerifyTitle() {

        String folderName = "First Search Article";
        String firstArticleFullDescription = "Object-oriented programming language";
        String firstSearch = "Java";
        String firstTitle = "Java (programming language)";
        String secondSearch = "World";
        String secondTitle = "World";
        String secondArticleFullDescription = "Planet Earth and all life upon it, including human civilization";
        boolean firstInList = true;
        Assert.assertTrue(
                "Search result was not added to list",
                createArticleForSearchWithName(firstSearch, firstInList, folderName, firstArticleFullDescription));
        firstInList = false;
        Assert.assertTrue(
                "Search result was not added to list",
                createArticleForSearchWithName(secondSearch, firstInList, folderName, secondArticleFullDescription));

        waitForElementPresentByAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Can not find My list button",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@text='" + folderName + "']"),
                "Can not find title of article",
                15);
        waitForElementPresentByAndClick(
                By.xpath("//*[@text='" + folderName + "']"),
                "Can not find title of article",
                15);

        swipeElementToLeft(
                By.xpath("//*[@text='" + firstTitle + "']"),
                "Can not swipe article");

        waitForElementNotPresent(
                By.xpath("//*[@text='" + firstTitle + "']"),
                "Article is not deleted",
                5);

        waitForElementPresentBy(
                By.xpath("//*[@text='" + secondTitle + "']"),
                "Can not find title of article",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='" + secondTitle + "']"),
                "Can not find title of article and click on it",
                15);

        waitForElementPresentBy(
                By.xpath("//*[@text='" + secondArticleFullDescription + "']"),
                "Can not find title of article",
                15);

    }

    private boolean createArticleForSearchWithName(String searchText, boolean firstInList, String articleName, String articleFullDescription) {
        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                searchText,
                "Edit text input not found",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + articleFullDescription + "']"),
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

        waitForElementPresentByAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Add to reading list menu was not found",
                5);

        if (firstInList) {
            waitForElementPresentByAndClick(
                    By.id("org.wikipedia:id/onboarding_button"),
                    "Add to reading list menu was not found",
                    5);
            waitForElementPresentByAndClear(
                    By.id("org.wikipedia:id/text_input"),
                    "Can not clear input field 'My reading list'",
                    5);
            waitForElementPresentByAndSendKeys(
                    By.id("org.wikipedia:id/text_input"),
                    articleName,
                    "Edit text input not found",
                    5);
            waitForElementPresentByAndClick(
                    By.xpath("//*[@text='OK']"),
                    "Ok button not found",
                    5);
        } else {
            waitForElementPresentByAndClick(
                    By.xpath("//*[@text='" + articleName + "']"),
                    "Ok button not found",
                    5);
        }
        waitForElementPresentByAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Can not close an article. X was not found",
                5);
        return true;
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

}
