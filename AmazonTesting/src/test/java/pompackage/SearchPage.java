package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Webelements
    @FindBy(id = "twotabsearchtextbox") // Search bar
    WebElement searchBar;

    @FindBy(id ="nav-search-submit-button") // Search button
    WebElement searchButton;

    @FindBy(xpath ="//a[contains(@aria-label, 'Next')]") // Pagination button
    WebElement nextPageButton;

    // Methods
    public void searchProduct(String keyword) {
        searchBar.sendKeys(keyword);
        searchButton.click();
    }

    public void navigateToNextPage() {
        nextPageButton.click();
    }

    public boolean isNextPageButtonEnabled() {
        return nextPageButton.isEnabled();
    }
}

