package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SizePage extends BasePageObject {
    private static final String
            BUTTON_NEXT = "buttonSave",
            SHOE_SIZE = "horizontalPickerShoeSize",
            TROUSERS_WAIST = "horizontalPickerTrousersWidth",
            TROUSERS_LENGHT = "horizontalPickerTrousersLength",
            SHIRT_SIZE = "horizontalPickerShirtSize",
            HAIR_COLOR = "horizontalPickerHairColor";

    public SizePage(AppiumDriver driver) {
        super(driver);
    }

    public void selectHair() {
        waitForElementPresentByAndClick(
                By.id(HAIR_COLOR),
                "Can not find and click hair color",
                15);
    }

    public void selectShirtSize() {
//        swipeUpToElementPresent(
//                By.id(SHIRT_SIZE),
//                "Can not find shirt size",
//                3);
        waitForElementPresentByAndClick(
                By.id(SHIRT_SIZE),
                "Can not find and click shirt size",
                15);
    }

    public void selectTrousersWaist() {
//        swipeUpToElementPresent(
//                By.id(TROUSERS_WAIST),
//                "Can not find trousers waist ",
//                3);
        waitForElementPresentByAndClick(
                By.id(TROUSERS_WAIST),
                "Can not find and click trouser waist",
                15);
    }

    public void selectTrousersLength() {
        swipeUpToElementPresent(
                By.id(SHOE_SIZE),
                "Can not find register button",
                3);
        waitForElementPresentByAndClick(
                By.id(TROUSERS_LENGHT),
                "Can not find and click trowser length",
                15);
    }

    public void selectShoeSize() {
//        swipeUpToElementPresent(
//                By.id(SHOE_SIZE),
//                "Can not find register button",
//                3);
        waitForElementPresentByAndClick(
                By.id(SHOE_SIZE),
                "Can not find and click shoe size",
                15);
    }

    @Override
    public void clickOnNextButton(){
        swipeUpToElementPresent(
                By.id(BUTTON_NEXT),
                "Can not find next button",
                3);

        waitForElementPresentByAndClick(
                By.id(BUTTON_NEXT),
                "Can not click next button",
                15);
    }
}
