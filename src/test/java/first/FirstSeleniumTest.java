package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    // TestNG annotation to give us a way to run this code before the class (setup code)
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Loads the new web page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // TestNG annotation for wrap up
    @AfterClass
    public void tearDown() {
        // Closes every window and quits the driver (this is the standard)
        // driver.quit();

        // Only closes the current window
        // driver.close();
    }

    // TestNG annotation which identifies the test method
    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        /*
        * TWO Key Steps for automation
        * 1. Find the web element
        * 2. Perform an action on the element
        * */

        // Sleep statement before entering username
        Thread.sleep(10000);

        // Step 1: By is a class used to locate elements (we have 8 locators)
        // By.className, By.cssSelector, By.id, By.link, By.name, By.partialLinkTest, By.tagName, By.xpath
        WebElement username = driver.findElement(By.name("username"));

        // Step 2: We now perform an action using sendkeys to send information to the element
        username.sendKeys("Admin");

        // Step 1: Find the pw element now using the other way of finding an element (var)
        // var is a java keyword that infers the data type
        var password = driver.findElement(By.name("password"));

        // Step 2: Perform an action to our password
        password.sendKeys("admin123");

        // Last step is to click the log in button and since we only have 1 button on the page, it is unique
        // So we use the tag name <button> to find it
        // We do step 1 & step 2 at the same time, find it then click
        driver.findElement(By.tagName("button")).click();

        // Thread.sleep is really not recommended cause it's a hard stop so this is for demo purposes
        // Selenium has diff ways to WAIT, and there are better alternatives than thread.sleep
        Thread.sleep(10000);

        // [VERIF] Verify test via assertion
        // Step 1: We get the dashboard to verify if we're on the dashboard - getText returns string
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult);
    }

}
