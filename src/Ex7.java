import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Ex7 {
    /*
    Appium устроен так, что может сохранить у себя в памяти поворот экрана,
     который использовался в предыдущем тесте,
      и начать новый тест с тем же поворотом.
      Мы написали тест на поворот экрана, и он может сломаться до того,
      как положение экрана восстановится.
      Следовательно, если мы запустим несколько тестов одновременно,
       последующие тесты будут выполняться в неправильном положении экрана,
       что может привести к незапланированным проблемам.

Как нам сделать так, чтобы после теста на поворот экрана
 сам экран всегда оказывался в правильном положении,
 даже если тест упал в тот момент, когда экран был наклонен?
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

        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testChangeScreenOrientation() {

        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);
        Assert.assertTrue(driver.getOrientation().equals(ScreenOrientation.PORTRAIT));
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Assert.assertTrue(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE));

    }

    @Test
    public void testChangeScreenOrientation1() {
        Assert.assertTrue(driver.getOrientation().equals(ScreenOrientation.PORTRAIT));
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Assert.assertTrue(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE));
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


}
