package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.waitForTitleElement();
        String article_title = articlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";

        articlePageObject.addArticleToMyList(name_of_folder);
        articlePageObject.closeArticle();

        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickMyList();

        MyListPageObject myList = new MyListPageObject(driver);
        myList.openFolderByName(name_of_folder);
        myList.swipeByArticleToDelete(article_title);

    }
}
