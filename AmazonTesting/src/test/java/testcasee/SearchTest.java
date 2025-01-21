package testcasee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.SearchPage;

public class SearchTest {

	WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
       driver.get("https://www.amazon.ca");
        driver.manage().window().maximize();
        searchPage = new SearchPage(driver);
    }

    @Test(priority = 1)
    public void testSearchProduct() {
       searchPage.searchProduct("laptop"); // Perform a search
        Assert.assertTrue(driver.getTitle().contains("laptop"), "Search results not displayed correctly!");
    }

    @Test(priority = 2)
    public void testPagination() {
       searchPage.searchProduct("headphones"); // Perform a search
        Assert.assertTrue(searchPage.isNextPageButtonEnabled(), "Next page button is not enabled!");
        searchPage.navigateToNextPage(); // Navigate to the next page
       Assert.assertTrue(driver.getCurrentUrl().contains("page=2"), "Pagination to next page failed!");
    }

    @AfterMethod
    public void tearDown() {
       driver.quit(); // Close the browser
    }
}

