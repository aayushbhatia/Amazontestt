package testcasee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.LoginPage;

public class LoginTest {

	WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
       driver = new ChromeDriver(); // Launches a new browser instance
        driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fref%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0"); // Navigates to the Amazon.ca login page
        driver.manage().window().maximize(); // Maximizes the browser window
        loginPage = new LoginPage(driver); // Creates an object for the LoginPage class
    }

    @Test(priority = 1)
    public void testValidLogin() {
        loginPage.enterEmail("aayushbhatiaca@gmail.com"); // Enters a valid email
       loginPage.conButton();
        loginPage.enterPassword("Abhi@2599"); // Enters a valid password
       loginPage.clickLoginButton(); // Clicks the signin button

        // Validate that the URL contains "your-account" after login
       // Assert.assertTrue(driver.getCurrentUrl().contains("your-account"), "Login failed!");
    }
 
    @Test(priority = 2)
    public void testInvalidLogin() {
        loginPage.enterEmail("Ahiquhwh@gmail.com"); // Enters an invalid email
       loginPage.enterPassword("Abjhdb@15"); // Enters an invalid password
        loginPage.clickLoginButton(); // Clicks the Signin button

        String actualMessage = loginPage.getErrorMessage();
       String expectedMessage = "Incorrect email or password";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
    
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // Closes the browser after each test
    }
}
