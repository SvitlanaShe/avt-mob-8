package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String appiumUrl = "http://127.00.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        File appDir = new File("apks");
        File app = new File(appDir, "outfittery2301.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidTestDevice");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,120);
        capabilities.setCapability("appPackage", "de.outfittery.app.debug");
        capabilities.setCapability("appActivity", "de.outfittery.appmain.ui.newuser.welcome.WelcomeActivity");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());//"C:\\Users\\svitlana.shepotilova.PS-1142-PC\\AndroidStudioProjects\\save\\JavaAppiumAutomation\\apks\\outfittery2301.apk");

        driver = new AndroidDriver(new URL(appiumUrl), capabilities);
        rotateScreenPortrait();
    }

    @Override
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds) {
        driver.runAppInBackground(seconds);
    }
}
