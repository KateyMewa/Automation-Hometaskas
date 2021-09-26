package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='button-reset search-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='category-items flex-wrap']//div[@class='category-box-wrap category-box-wrap--main ']//a[contains(@href, '/tradein')]")
    private WebElement tradeinLink;

    @FindBy(xpath = "//div[@class='all-category-box js_category-box height add-more']//a[contains(@href, 'iphone')]")
    private WebElement sectionLink;

    @FindBy(xpath = "//a[@class='category-product']")
    public WebElement suggestedProductsInSearch;

    @FindBy(xpath = "//a[@class='category-product']")
    public List<WebElement> getSuggestedProductsList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void goToTradeinPage() {
        tradeinLink.click();
    }

    public void goToRequiredSection() {
        sectionLink.click();
    }

    public void insertKeywordInSearchInput(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public Integer getSuggestedProductsNumber() {
        return getSuggestedProductsList.size();
    }
}
