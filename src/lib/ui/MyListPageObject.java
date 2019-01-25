package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListPageObject extends MainPageObject {
    public static final String
            FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
            ARTICLE_BY_TITLE_TPL = "//*[@text='{TITLE}']";

    private static String getFolderByName(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    public MyListPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName(String name_of_folder) {
        this.waitForElementPresentByAndClick(
                By.xpath(getFolderByName(name_of_folder)),
                "Can not find folder by name " + name_of_folder,
                15);
    }

    public void swipeByArticleToDelete(String artice_title) {
        waitForArticleToAppearByTitle(artice_title);
        String articleLocator = getSavedArticleLocatorByTitle(artice_title);
        this.swipeElementToLeft(
                By.xpath(articleLocator),
                "Can not swipe article");
        waitForArticleToDissappearByTitle(artice_title);
    }

    public void waitForArticleToDissappearByTitle(String artice_title) {
        String articleLocator = getSavedArticleLocatorByTitle(artice_title);
        this.waitForElementNotPresent(
                By.xpath(articleLocator),
                "Article is not deleted",
                15);
    }

    public void waitForArticleToAppearByTitle(String artice_title) {
        String articleLocator = getSavedArticleLocatorByTitle(artice_title);
        this.waitForElementPresentBy(
                By.xpath(articleLocator),
                "Article not appears!",
                15);
    }

    private String getSavedArticleLocatorByTitle(String artice_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", artice_title);
    }
}
