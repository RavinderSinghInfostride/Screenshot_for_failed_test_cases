package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameInputBox;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInputBox;
    @FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() throws Exception {
        Thread.sleep(3000);
        usernameInputBox.sendKeys("Admin");
        passwordInputBox.sendKeys("admin123");
        loginButton.click();
    }
}