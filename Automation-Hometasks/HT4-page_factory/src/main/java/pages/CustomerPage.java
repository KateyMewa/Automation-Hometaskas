package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends BasePage {

    @FindBy(xpath = "//div[@class='recently-viewed-products visible']//a[text()='Переглянути'][1]")
    private WebElement lookThroughButton;

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void clickLookThroughButton() {
        lookThroughButton.click();
    }
}
