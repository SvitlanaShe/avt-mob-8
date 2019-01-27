package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WhatHappensNextPage extends BasePageObject {
    private static final String OCCASION_IMAGE = "cardView",
            TEXT_INPUT = "textInputEditTextAdditionalInfo";

    public WhatHappensNextPage(AppiumDriver driver) {
        super(driver);
    }
}
