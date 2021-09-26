package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SectionPage extends BasePage {

    @FindBy(xpath = "//a[@class='filter-link' and text()='iPhone 12 Pro Max']")
    public WebElement filterTag;

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    public List<WebElement> filterResultsProductList;

    public SectionPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFilterTag() {
        filterTag.click();
    }
}
