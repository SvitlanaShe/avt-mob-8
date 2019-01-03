import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Ex6 {
    /*
    Написать тест, который открывает статью и убеждается,
     что у нее есть элемент title.
      Важно: тест не должен дожидаться появления title,
      проверка должна производиться сразу.
       Если title не найден - тест падает с ошибкой.
     Метод можно назвать assertElementPresent.
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
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkTitlePresent() {
        String text = "Java";
        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);
        waitForElementPresentBy(By.xpath("//*[@text='Search and read the free encyclopedia in your language']"), "Text not found.", 5);
        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Page title was not found",
                1);
        assertElementPresent(By.id("org.wikipedia:id/view_page_title_text"), "Title of article  was not found ");
        assertElementPresent(By.id("org.wikipedia:id/incorrectElement"), "This asssertion should fail because element is not present");

    }

    private int getAmountOfElements(By by) {
        return driver.findElements(by).size();
    }

    private void assertElementPresent(By by, String errorMessage) {
        if (getAmountOfElements(by) == 0) {
            throw new AssertionError(errorMessage + " Locator was not found. Locator: " + by);
        }
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
