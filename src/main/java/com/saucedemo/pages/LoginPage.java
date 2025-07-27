package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("#login_button_container h3");
    private final By errorMessage = By.id("login-button");

    /*
    * There are 4 TYPES of methods that we can use in our Page Object Model
    * 1. Getter: Returns the value of an attribute
    * 2. Setter: Receives param/s and assigns to the attribute
    * 3. Transition: Important when the application changes to a diff page
    * 4. Convenience: Created when combining more than one method into a single method
    * */
    public void setUsernameField(String username) {
        set(usernameField, username);
    }

    public void setPasswordField(String password) {
        set(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

}
