package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By adminMenuOption = By.xpath("(//a[@class='oxd-main-menu-item'])[1]");
    By verifyAdminPage = By.xpath("//h6[contains(text(),'User Management')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToAdminPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminMenuOption));
        driver.findElement(adminMenuOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyAdminPage));
        String adminPageVerifyText = driver.findElement(verifyAdminPage).getText();
        Assert.assertEquals(adminPageVerifyText, "Admin");
    }
}