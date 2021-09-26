package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class AuthorizationPage extends BasePage {

    private static final String EMAIL = "katerina10993@gmail.com";
    private static final String PASSWORD = "Myjyskpass1";

    @FindBy(xpath = "//input[@name='email' and @class='form-control']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password' and @class='form-control']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public void authorization() {
        emailField.sendKeys(EMAIL);
        passwordField.sendKeys(PASSWORD);
        loginButton.click();
    }
}
