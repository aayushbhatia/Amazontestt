package testcasee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.RegisterPage;

public class RegisterTest {

	WebDriver driver;
    RegisterPage registerPage; 

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.ca/ap/register");
       driver.manage().window().maximize();
        registerPage = new RegisterPage(driver); // Updated object creation
    }

    @Test(priority = 1)
    public void testValidRegistration() {
       registerPage.enterName("aayush bhatia");
      registerPage.enterEmail("aayushbhatiaca@gmail.com");
       registerPage.enterPassword("Abhi@2599");
        registerPage.clickRegisterButton();
    }

    @Test(priority = 2)
    public void testEmptyNameField() {
        registerPage.enterName("");
       registerPage.enterEmail("aayushbhatiaca@gmail.com");
        registerPage.enterPassword("Abhi@2599");
        registerPage.clickRegisterButton();
       String actualMessage = registerPage.getErrorMessage();
        String expectedMessage = "Enter your name";
       Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
    }

    @AfterMethod
    public void closeDown() {
        driver.quit();
    }
}

