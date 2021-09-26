package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage {

    @FindBy(xpath = "//section[@class='my-jysk-wishlist']//span[@class='product-name']")
    public List<WebElement> getWishlistProducts;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }
}
