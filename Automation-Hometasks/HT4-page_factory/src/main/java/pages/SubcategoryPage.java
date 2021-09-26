package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubcategoryPage extends BasePage {

    @FindBy(xpath = "//article[contains(@about, 'denno')]")
    private WebElement productVaseDennoLink;

    public SubcategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickProductVaseDennoLink() {
        productVaseDennoLink.click();
    }
}
