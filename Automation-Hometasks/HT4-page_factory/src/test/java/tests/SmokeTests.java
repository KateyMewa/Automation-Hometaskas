package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SmokeTests extends BaseTests {



    @Test(priority = 1)
    public void checkThatRequiredCategoriesAreDisplayedAtHomePage() {
        getHomePage().waitForPageLoadComplete(60);
        getHomePage().closeCookiePopup();
        assertTrue(getHomePage().searchSection.isDisplayed());
        assertTrue(getHomePage().bannerSection.isDisplayed());
        assertTrue(getHomePage().categoriesSection.isDisplayed());
        assertTrue(getHomePage().newsletterSection.isDisplayed());
    }

    @Test(priority = 2)
    public void checkCartShowsNumberOfAddedToCartProducts() {
        doProductView();
        getProductPage().clickAddToCartButton();
        getProductPage().waitVisibilityOfElement(120, By.xpath("//div[@id='notification-container']"));
        getProductPage().clickContinueShoppingButton();
        getProductPage().waitForPageLoadComplete(60);
        assertEquals(getProductPage().productsAmountInCart.getText(), "1");
    }

    @Test(priority = 3)
    public void checkThatTheProductIsAddedToWishlist() {
        doProductView();
        getProductPage().waitVisibilityOfElement(60, By.xpath("//a[@href='/customer/login']"));
        getProductPage().goToAuthorization();
        getAuthorizationPage().waitForPageLoadComplete(120);
        getAuthorizationPage().authorization();
        getCustomerPage().waitForPageLoadComplete(120);
        getCustomerPage().waitVisibilityOfElement(60, By.xpath("//div[@class='recently-viewed-products visible']//a[text()='Переглянути'][1]"));
        getCustomerPage().clickLookThroughButton();
        getProductPage().waitForPageLoadComplete(120);
        getProductPage().clickAddToWishlistButton();
        getProductPage().waitVisibilityOfElement(120, By.xpath("//div[@class='modal-body']//a[@href='/customer/wishlist']"));
        getProductPage().clickWishlistLink();
        getWishlistPage().waitForPageLoadComplete(120);
        boolean isProductInWishlist = false;
        for (WebElement product : getWishlistPage().getWishlistProducts) {
            if(product.getText().equals(getProductPage().getProductName())) {
                isProductInWishlist = true;
                break;
            }
        }
        assertTrue(isProductInWishlist);

    }
}
