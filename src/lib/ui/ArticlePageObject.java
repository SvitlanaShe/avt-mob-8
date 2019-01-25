package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "//*[@text='View page in browser']",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresentBy(
                By.id(TITLE),
                "Can not find title element",
                15);
    }

    public String getArticleTitle() {
        WebElement titleElement = waitForTitleElement();
        return titleElement.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToElementPresent(
                By.xpath(FOOTER_ELEMENT),
                "Cann not find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementPresentByAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Button More options was not found",
                5);

        this.waitForElementPresentByAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Add to reading list menu was not found",
                5);

        this.waitForElementPresentByAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Add to reading list menu was not found",
                5);

        this.waitForElementPresentByAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Can not clear input field 'My reading list'",
                5);

        this.waitForElementPresentByAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Edit text input not found",
                5);

        this.waitForElementPresentByAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Ok button not found",
                5);
    }

    public void closeArticle() {
        this.waitForElementPresentByAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Can not close an article. X was not found",
                5);
    }
}

