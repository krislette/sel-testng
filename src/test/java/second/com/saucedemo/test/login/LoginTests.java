package second.com.saucedemo.test.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import second.com.saucedemo.base.BaseTest;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginErrorMessage() {
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("wrong_password");
        // This returns the products page since this is a transition
        // But we wont be storing it since the execution stops after we verified the error on login page
        // var productsPage = loginPage.clickLoginButton();
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();

        // Verification
        Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }

}
