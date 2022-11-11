package Test;

import Pages.BaseClass;
import org.testng.annotations.Test;

public class ToVerifyUserIsRedirectedToAdminPage extends BaseClass {
    @Test(priority = 0)
    public void login() throws Exception {
        pageFactory.getLoginPage().login();
    }

    @Test(priority = 1)
    public void RedirectToAdminPage() throws InterruptedException {
        pageFactory.getHomePage().navigateToAdminPage();
    }
}