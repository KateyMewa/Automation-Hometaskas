package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//div[@about='/dlya-domu/dekor']//a[@href]")
    private WebElement dekorSection;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickDekorSection() {
        dekorSection.click();
    }
}
