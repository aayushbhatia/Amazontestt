package testcasee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.ShoppingCartPage;

public class ShoppingCartTest {

	WebDriver driver;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
       driver.get("https://www.amazon.ca"); // acc ount should be open
        driver.manage().window().maximize();
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test(priority = 1)
    public void testAddToCart() {
       shoppingCartPage.addProductToCart(); // Add a product to the cart
        shoppingCartPage.navigateToCart(); // Navigate to the cart
       Assert.assertTrue(shoppingCartPage.getCartCount() > 0, "Product not added to the cart!");
    }

    @Test(priority = 2)
    public void testRemoveFromCart() {
        shoppingCartPage.addProductToCart(); // Add a product to the cart
       shoppingCartPage.navigateToCart(); // Navigate to the cart
        shoppingCartPage.removeProductFromCart(); // Remove the product
        Assert.assertEquals(shoppingCartPage.getCartCount(), 0, "Product not removed from the cart!");
    }

    @AfterMethod
    public void tearDown() {
      driver.quit(); // Close the browser
    }
}
