
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Ex5 extends CoreTestCase {
    /*
    Написать тест, который:
1. Сохраняет две статьи в одну папку
2. Удаляет одну из статей
3. Убеждается, что вторая осталась
4. Переходит в неё и убеждается, что title совпадает
     */

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testAddTwoArticlesDeleteOneAndVerifyTitle() {

        String folderName = "First Search Article";
        String firstArticleFullDescription = "Object-oriented programming language";
        String firstSearch = "Java";
        String firstTitle = "Java (programming language)";
        String secondSearch = "World";
        String secondTitle = "World";
        String secondArticleFullDescription = "Planet Earth and all life upon it, including human civilization";
        boolean firstInList = true;
        Assert.assertTrue(
                "Search result was not added to list",
                createArticleForSearchWithName(firstSearch, firstInList, folderName, firstArticleFullDescription));
        firstInList = false;
        Assert.assertTrue(
                "Search result was not added to list",
                createArticleForSearchWithName(secondSearch, firstInList, folderName, secondArticleFullDescription));

        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Can not find My list button",
                5);

        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@text='" + folderName + "']"),
                "Can not find title of article",
                15);
        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@text='" + folderName + "']"),
                "Can not find title of article",
                15);

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='" + firstTitle + "']"),
                "Can not swipe article");

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='" + firstTitle + "']"),
                "Article is not deleted",
                5);

        MainPageObject.waitForElementPresentBy(
                By.xpath("//*[@text='" + secondTitle + "']"),
                "Can not find title of article",
                5);

        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='" + secondTitle + "']"),
                "Can not find title of article and click on it",
                15);

        MainPageObject.waitForElementPresentBy(
                By.xpath("//*[@text='" + secondArticleFullDescription + "']"),
                "Can not find title of article",
                15);

    }

    private boolean createArticleForSearchWithName(String searchText, boolean firstInList, String articleName, String articleFullDescription) {
        MainPageObject.waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        MainPageObject.waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                searchText,
                "Edit text input not found",
                5);

        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + articleFullDescription + "']"),
                "Page title was not found",
                15);
        MainPageObject.waitForElementPresentBy(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Page title was not found",
                15);
        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Button More options was not found",
                5);

        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Add to reading list menu was not found",
                5);

        if (firstInList) {
            MainPageObject.waitForElementPresentByAndClick(
                    By.id("org.wikipedia:id/onboarding_button"),
                    "Add to reading list menu was not found",
                    5);
            MainPageObject.waitForElementPresentByAndClear(
                    By.id("org.wikipedia:id/text_input"),
                    "Can not clear input field 'My reading list'",
                    5);
            MainPageObject.waitForElementPresentByAndSendKeys(
                    By.id("org.wikipedia:id/text_input"),
                    articleName,
                    "Edit text input not found",
                    5);
            MainPageObject.waitForElementPresentByAndClick(
                    By.xpath("//*[@text='OK']"),
                    "Ok button not found",
                    5);
        } else {
            MainPageObject.waitForElementPresentByAndClick(
                    By.xpath("//*[@text='" + articleName + "']"),
                    "Ok button not found",
                    5);
        }
        MainPageObject.waitForElementPresentByAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Can not close an article. X was not found",
                5);
        return true;
    }

}
