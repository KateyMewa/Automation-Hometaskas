package Avic;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.AssertJUnit.assertTrue;

public class SectionTests extends BaseTests {

    private static final String FILTER_WORD = "Pro Max";

    @Test(priority = 1)
    public void checkThatResultsCorrespondChosenFilter() {
        getHomePage().waitForPageLoadComplete(30);
        getHomePage().goToRequiredSection();
        getSearchResultsPage().waitForPageLoadComplete(30);
        getSectionPage().clickOnFilterTag();
        getSectionPage().waitForPageLoadComplete(30);
        for (WebElement element : getSectionPage().filterResultsProductList) {
            assertTrue(element.getText().contains(FILTER_WORD));
        }
    }
}
