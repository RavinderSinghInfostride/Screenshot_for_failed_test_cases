package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;

public class BaseClass {
    public WebDriver driver;
    protected PageFactory pageFactory;

    @BeforeSuite
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        pageFactory = new PageFactory(driver);
    }

//    public void takeSnapShot(String fileWithPath) throws Exception {
//        TakesScreenshot scrShot = ((TakesScreenshot) driver);
//        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//        File DestFile = new File(fileWithPath);
//        FileUtils.copyFile(SrcFile, DestFile);
//    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("C:\\Users\\RavinderSingh\\IdeaProjects\\Screenshot\\Screenshots\\" + result.getName() + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}