package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePageObject {
    private static final String LOGO = "imageViewLogo",
            BUTTON_GET_STARTED = "buttonGetStarted",
            BUTTON_LOGIN = "buttonLogin",
            TEXT_VIEW_OOTW = "textWithOOTW";

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnLogo() {
        waitForElementPresentByAndClick(
                By.id(LOGO),
                "Staging activated",
                5);
    }

    public void clickOnGetStartedButton() {
        waitForElementPresentByAndClick(
                By.id(BUTTON_GET_STARTED),
                "Get started button is not clicked!",
                5);
    }

    public void clickOnLoginButton() {
        waitForElementPresentByAndClick(
                By.id(BUTTON_LOGIN),
                "Login button is not clicked!",
                5);
    }

    public void clickOnViewOOTW() {
        waitForElementPresentByAndClick(
                By.id(TEXT_VIEW_OOTW),
                "View OOTW button is not clicked! ",
                5);
    }
}
