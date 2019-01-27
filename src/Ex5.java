
import lib.CoreTestCase;
import lib.ui.BasePageObject;
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

    private BasePageObject BasePageObject;

    protected void setUp() throws Exception {
        super.setUp();
        BasePageObject = new BasePageObject(driver);
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

        BasePageObject.waitForElementPresentByAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Can not find My list button",
                5);

        BasePageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@text='" + folderName + "']"),
                "Can not find title of article",
                15);
        BasePageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@text='" + folderName + "']"),
                "Can not find title of article",
                15);

        BasePageObject.swipeElementToLeft(
                By.xpath("//*[@text='" + firstTitle + "']"),
                "Can not swipe article");

        BasePageObject.waitForElementNotPresent(
                By.xpath("//*[@text='" + firstTitle + "']"),
                "Article is not deleted",
                5);

        BasePageObject.waitForElementPresentBy(
                By.xpath("//*[@text='" + secondTitle + "']"),
                "Can not find title of article",
                5);

        BasePageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='" + secondTitle + "']"),
                "Can not find title of article and click on it",
                15);

        BasePageObject.waitForElementPresentBy(
                By.xpath("//*[@text='" + secondArticleFullDescription + "']"),
                "Can not find title of article",
                15);

    }

    private boolean createArticleForSearchWithName(String searchText, boolean firstInList, String articleName, String articleFullDescription) {
        BasePageObject.waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);

        BasePageObject.waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                searchText,
                "Edit text input not found",
                5);

        BasePageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + articleFullDescription + "']"),
                "Page title was not found",
                15);
        BasePageObject.waitForElementPresentBy(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Page title was not found",
                15);
        BasePageObject.waitForElementPresentByAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Button More options was not found",
                5);

        BasePageObject.waitForElementPresentByAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Add to reading list menu was not found",
                5);

        if (firstInList) {
            BasePageObject.waitForElementPresentByAndClick(
                    By.id("org.wikipedia:id/onboarding_button"),
                    "Add to reading list menu was not found",
                    5);
            BasePageObject.waitForElementPresentByAndClear(
                    By.id("org.wikipedia:id/text_input"),
                    "Can not clear input field 'My reading list'",
                    5);
            BasePageObject.waitForElementPresentByAndSendKeys(
                    By.id("org.wikipedia:id/text_input"),
                    articleName,
                    "Edit text input not found",
                    5);
            BasePageObject.waitForElementPresentByAndClick(
                    By.xpath("//*[@text='OK']"),
                    "Ok button not found",
                    5);
        } else {
            BasePageObject.waitForElementPresentByAndClick(
                    By.xpath("//*[@text='" + articleName + "']"),
                    "Ok button not found",
                    5);
        }
        BasePageObject.waitForElementPresentByAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Can not close an article. X was not found",
                5);
        return true;
    }

}
