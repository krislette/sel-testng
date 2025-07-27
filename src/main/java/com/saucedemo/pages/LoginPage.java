package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("#login_button_container h3");

    /*
    * There are 4 TYPES of methods that we can use in our Page Object Model
    * 1. Getter: Returns the value of an attribute
    * 2. Setter: Receives param/s and assigns to the attribute
    * 3. Transition: Important when the application changes to a diff page
    * 4. Convenience: Created when combining more than one method into a single method
    * */

    // Setters
    public void setUsernameField(String username) {
        set(usernameField, username);
    }

    public void setPasswordField(String password) {
        set(passwordField, password);
    }

    // Transition method
    public ProductsPage clickLoginButton() {
        click(loginButton);
        // Cause after we click the login button, the products page should appear
        return new ProductsPage();
    }

    // Convenience method
    // It's called *convenience* because it will combine
    // 1. Setting a username, 2. Setting a password, and 3. Clicking the login button
    // Into this one method
    public ProductsPage logIntoApplication(String username, String password) {
        setUsernameField(username);
        setPasswordField(password);
        return clickLoginButton();
    }

    // Getter method
    // which will get the error message
    public String getErrorMessage() {
        return find(errorMessage).getText();
    }
    
}
