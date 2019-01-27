package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends BasePageObject {

    private static String
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn";

    private static final By
            SEARCH_INPUT_ELEMENT = By.className("android.widget.TextView"),
            SEARCH_INPUT = By.className("android.widget.EditText");

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementPresentByAndClick(SEARCH_INPUT_ELEMENT, "Can not find and click init search element", 5);
        this.waitForElementPresentBy(SEARCH_INPUT, "Can not fimd search input after clicking init search element");
    }

    public void typeSearchLine(String line) {
        this.waitForElementPresentByAndSendKeys(SEARCH_INPUT, line, "Can not find and type in init search result", 5);
    }

    public void waitForSearchResult(String substring) {
        this.waitForElementPresentBy(By.xpath(getResultSearchElement(substring)), "Can not find search result");
    }

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresentBy(By.id(SEARCH_CANCEL_BUTTON), "Can not find search cancel button!", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button still present!", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementPresentByAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and clickearch cancel button!", 5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_resut_xpath = getResultSearchElement(substring);
        this.waitForElementPresentByAndClick(By.xpath(search_resut_xpath), "Can not find and click search result with substring" + substring, 5);
    }
}
