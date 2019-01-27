
import lib.CoreTestCase;
import lib.ui.BasePageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex6 extends CoreTestCase {
    /*
    Написать тест, который открывает статью и убеждается,
     что у нее есть элемент title.
      Важно: тест не должен дожидаться появления title,
      проверка должна производиться сразу.
       Если title не найден - тест падает с ошибкой.
     Метод можно назвать assertElementPresent.
     */

    private BasePageObject BasePageObject;

    protected void setUp() throws Exception {
        super.setUp();
        BasePageObject = new BasePageObject(driver);
    }

    @Test
    public void testCheckTitlePresent() {
        String text = "Java";
        waitForElementPresentByAndClick(
                By.className("android.widget.TextView"),
                "Text element not found",
                5);
        waitForElementPresentBy(By.xpath("//*[@text='Search and read the free encyclopedia in your language']"), "Text not found.", 5);
        waitForElementPresentByAndSendKeys(
                By.className("android.widget.EditText"),
                text,
                "Edit text input not found",
                5);

        waitForElementPresentByAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Page title was not found",
                1);
        assertElementPresent(By.id("org.wikipedia:id/view_page_title_text"), "Title of article  was not found ");
        assertElementPresent(By.id("org.wikipedia:id/incorrectElement"), "This asssertion should fail because element is not present");

    }

    private int getAmountOfElements(By by) {
        return driver.findElements(by).size();
    }

    private void assertElementPresent(By by, String errorMessage) {
        if (getAmountOfElements(by) == 0) {
            throw new AssertionError(errorMessage + " Locator was not found. Locator: " + by);
        }
    }

    private WebElement waitForElementPresentBy(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresentByAndClick(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresentBy(by, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementPresentByAndSendKeys(By by, String keys, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresentBy(by, errorMessage, timeoutInSeconds);
        element.sendKeys(keys);
        return element;
    }
}
