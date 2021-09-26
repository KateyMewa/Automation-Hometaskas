package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@class='product-name']")
    public WebElement productName;

    @FindBy(xpath = "//a[contains(@class, 'add-to-basket')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='notification-container']")
    public By notificationPopup;

    @FindBy(xpath = "//span[@data-test='continueShoppingButton']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@data-test='wssPaymentBasketTeaser']//span[@id]")
    public WebElement productsAmountInCart;

    @FindBy(xpath = "//div[contains(@class, 'add-to-wishlist')]//*[name()='svg']")
    private WebElement addToWishlistIcon;

    @FindBy(xpath = "//div[@class='modal-content']")
    public By wishlistPopup;

    @FindBy(xpath = "//div[@class='modal-body']//a[@href='/customer/wishlist']")
    private WebElement wishlistLink;


    @FindBy(xpath = "//a[@href='/customer/login']")
    public WebElement authorizationButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", addToCartButton);
    }

    public void clickAddToWishlistButton() {
        addToWishlistIcon.click();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickWishlistLink() {
        wishlistLink.click();
    }

    public void goToAuthorization() {
        new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable((By.xpath("//a[@href='/customer/login']")))).click();
        new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@href='/customer/login']")))).click();
    }

    public String getProductName() {
       return productName.getText();
    }
}
