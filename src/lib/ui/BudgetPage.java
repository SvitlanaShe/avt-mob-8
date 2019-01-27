package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BudgetPage extends BasePageObject {
    private static final String
            BUTTON_NEXT = "buttonSave";

    public BudgetPage(AppiumDriver driver) {
        super(driver);
    }
    public void clickOnNextButton(){
        swipeUpToElementPresent(
                By.id(BUTTON_NEXT),
                "Can not find next button",
                3);

        waitForElementPresentByAndClick(
                By.id(BUTTON_NEXT),
                "Can not click next button",
                5);
    }
}
