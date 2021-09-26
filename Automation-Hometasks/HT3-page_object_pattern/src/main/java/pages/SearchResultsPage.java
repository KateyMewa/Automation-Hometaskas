package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    public List<WebElement> searchResultsProductList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
}
