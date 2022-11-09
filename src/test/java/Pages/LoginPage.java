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
        Thread.sleep(5000);
        usernameInputBox.sendKeys("Admin");
        passwordInputBox.sendKeys("admin123");
        loginButton.click();
        Thread.sleep(5000);
    }
//    @Test
//    public void testBStackTakeScreenShot() throws Exception {
//        WebDriver driver;
//        ChromeOptions chromeOptions = new ChromeOptions();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(chromeOptions);
//        driver.get("https://www.browserstack.com");
//        this.takeSnapShot(driver, "C:\\Users\\RavinderSingh\\IdeaProjects\\Screenshot\\Screenshots\\test.png");
//    }
//
//    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
//        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
//        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//        File DestFile = new File(fileWithPath);
//        FileUtils.copyFile(SrcFile, DestFile);
//    }
}