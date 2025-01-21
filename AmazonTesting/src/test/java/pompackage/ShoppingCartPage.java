package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	WebDriver driver;

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    // WebElements
    @FindBy(xpath = "//input[@value='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(id = "nav-cart")
    WebElement cartIcon;

    @FindBy(xpath = "//input[@value='Delete']")
    WebElement removeButton;

    @FindBy(id = "nav-cart-count")
    WebElement cartCount;

    // Methods
    public void addProductToCart() {
        addToCartButton.click();
    }

    public void navigateToCart() {
        cartIcon.click();
    }

    public void removeProductFromCart() {
        removeButton.click();
    }

    public int getCartCount() {
        return Integer.parseInt(cartCount.getText());
    }
}


