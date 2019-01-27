package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class JeansPage extends BasePageObject {
    private static final String JEANS = "android.widget.ImageView";

    public JeansPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectJeans() {
        waitForElementPresentByAndClick(
                By.className(JEANS),
                "Jeans image can not be found and clicked!",
                5);
    }
}
