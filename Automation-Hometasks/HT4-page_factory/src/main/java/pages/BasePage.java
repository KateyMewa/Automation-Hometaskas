package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait wait;

    public void waitForPageLoadComplete(long timeToWait) {
        (new WebDriverWait(this.driver, timeToWait)).until((webDriver) -> {
            return ((JavascriptExecutor)webDriver)
                    .executeScript("return document.readyState", new Object[0]).equals("complete");
        });
    }

    public void waitVisibilityOfElement(long timeToWait, By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
