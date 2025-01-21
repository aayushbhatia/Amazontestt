package testcasee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.OrdersPage;

public class OrdersTest {

	WebDriver driver;
    OrdersPage ordersPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.ca"); // Keep Sign in For performing this test
        driver.manage().window().maximize();
        ordersPage = new OrdersPage(driver);
    }

    @Test(priority = 1)
    public void testNavigateToOrders() {
        ordersPage.navigateToOrders(); // Navigate to the Orders page
        Assert.assertTrue(driver.getCurrentUrl().contains("order-history"), "Failed to navigate to Orders page!");
    }

    @Test(priority = 2)
    public void testTrackOrder() {
        ordersPage.navigateToOrders(); // Navigate to the Orders page
        ordersPage.trackOrder(); // Track a specific order
        Assert.assertTrue(driver.getTitle().contains("Track package"), "Failed to track the order!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // Close the browser
    }
}

