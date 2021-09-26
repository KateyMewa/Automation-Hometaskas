package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//section[@class='search']")
    public WebElement searchSection;

    @FindBy(xpath = "//section[contains(@class, 'blockbanner')]")
    public WebElement bannerSection;

    @FindBy(xpath = "//section[contains(@class, 'categories')]")
    public WebElement categoriesSection;

    @FindBy(xpath = "//section[@class='newsletter']")
    public WebElement newsletterSection;

    @FindBy(xpath = "//div[@about='/dlya-domu']")
    private WebElement forHomeSection;


    @FindBy(xpath = "//a[@id='cookieOk']")
    private WebElement closeCookieButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickForHomeSection() {
        forHomeSection.click();
    }

    public void closeCookiePopup() {
        closeCookieButton.click();
    }

}
