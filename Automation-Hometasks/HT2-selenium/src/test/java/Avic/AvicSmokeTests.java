package Avic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AvicSmokeTests<beforeTest> {
    private WebDriver driver;


    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testSutUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @Test(priority = 1)
    public void checkThatSearchSuggestsRelevantResults() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("AirPods");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='prod-cart__descr']"));
        for (WebElement webElement : elementList) {
            assertTrue(webElement.getText().contains("AirPods"));
        }
    }

    @Test(priority = 2)
    public void checkThatPageLeadsToRequiredForm() {
        driver.findElement(By.xpath("//div[@class='category-items flex-wrap']//div[@class='category-box-wrap category-box-wrap--main ']//a[contains(@href, '/tradein')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(driver.findElement(By.xpath("//div[@class='tradein-container']")).isDisplayed());
    }

    @Test(priority = 3)
    public void CheckThatProductsRecommendedAreRelevant() {
        driver.findElement(By.xpath("//div[@class='all-category-box js_category-box height add-more']//a[contains(@href, 'iphone')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='filter-link' and text()='iPhone 12 Pro Max']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='prod-cart__descr']"));
        for (WebElement webElement : webElements) {
            assertTrue(webElement.getText().contains("Pro Max"));
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
