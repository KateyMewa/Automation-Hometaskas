package Avic;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TradeinTests extends BaseTests {

    @Test(priority = 1)
    public void checkTradeinFromIsDisplayed() {
        getHomePage().goToTradeinPage();
        getTradeinPage().waitForPageLoadComplete(30);
        assertTrue(getTradeinPage().tradeinForm.isDisplayed());
    }
}
