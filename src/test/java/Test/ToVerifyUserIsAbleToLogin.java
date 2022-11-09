package Test;

import Pages.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToVerifyUserIsAbleToLogin extends BaseClass {
    By verify = By.xpath("//h6");

    @Test
    public void login() throws Exception {
        pageFactory.getLoginPage().login();
        String text = driver.findElement(verify).getText();
        System.out.println(text);
        Assert.assertEquals(text, "Dashboar");
//        takeSnapShot("C:\\Users\\RavinderSingh\\IdeaProjects\\Screenshot\\Screenshots\\test.png");
    }
}