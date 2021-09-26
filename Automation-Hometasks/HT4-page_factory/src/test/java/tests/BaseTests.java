package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;
import pages.*;
import utils.CapabilityFactory;

import javax.xml.catalog.Catalog;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String JYSK_URL = "https://jysk.ua/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("firefox") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://10.0.1.93:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(JYSK_URL);
    }

    @AfterMethod
    public void tearDown() { getDriver().close();}

    @AfterClass
    void terminate() {driver.remove();}

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() { return new HomePage(getDriver()); }

    public CategoryPage getCategoryPage() { return new CategoryPage(getDriver()); }

    public SubcategoryPage getSubcategoryPage() { return new SubcategoryPage(getDriver()); }

    public ProductPage getProductPage() { return new ProductPage(getDriver()); }

    public AuthorizationPage getAuthorizationPage() { return new AuthorizationPage(getDriver()); }

    public CustomerPage getCustomerPage() { return new CustomerPage(getDriver()); }

    public WishlistPage getWishlistPage() { return new WishlistPage(getDriver()); }

    public void doProductView() {
        getHomePage().waitForPageLoadComplete(60);
        getHomePage().closeCookiePopup();
        getHomePage().clickForHomeSection();
        getCategoryPage().waitForPageLoadComplete(60);
        getCategoryPage().clickDekorSection();
        getSubcategoryPage().waitForPageLoadComplete(60);
        getSubcategoryPage().clickProductVaseDennoLink();
        getProductPage().waitForPageLoadComplete(60);
    }
}
