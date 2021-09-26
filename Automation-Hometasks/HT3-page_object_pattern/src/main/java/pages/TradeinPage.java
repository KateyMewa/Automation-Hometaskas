package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TradeinPage extends BasePage{

    @FindBy(xpath = "//div[@class='tradein-container']")
    public WebElement tradeinForm;

    public TradeinPage(WebDriver driver) {
        super(driver);
    }
}
