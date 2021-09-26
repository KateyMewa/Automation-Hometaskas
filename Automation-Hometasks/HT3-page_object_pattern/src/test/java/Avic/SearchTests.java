package Avic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SearchTests extends BaseTests {

    private static final String KEYWORD = "IPhone";
    private static final Integer SUGGESTED_PRODUCTS_AMOUNT = 3;

    @Test(priority = 1)
    public void checkThatSearchSuggestsRelevantResults() {
        getHomePage().waitForPageLoadComplete(30);
        getHomePage().searchByKeyword(KEYWORD);
        getSearchResultsPage().waitForPageLoadComplete(30);
        for(WebElement element : getSearchResultsPage().searchResultsProductList) {
            assertTrue(element.getText().toLowerCase().contains(KEYWORD.toLowerCase()));
        }
    }

    @Test(priority = 2)
    public void checkThatProductsAreSuggestedAfterInputtingSearchKeyWord() {
        getHomePage().waitForPageLoadComplete(30);
        getHomePage().insertKeywordInSearchInput(KEYWORD);
        getHomePage().waitVisibilityOfElement(30, By.xpath("//div[@class='search-suggest']"));
        assertEquals(getHomePage().getSuggestedProductsNumber(), SUGGESTED_PRODUCTS_AMOUNT);
    }
}
