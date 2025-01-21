package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

	WebDriver driver;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(id = "nav-orders") // Orders link
    WebElement ordersLink;

    @FindBy(xpath = "//a[contains(text(),'Track package')]") // Track order
    WebElement trackOrderLink;

    // Methods
    public void navigateToOrders() {
        ordersLink.click();
    }

    public void trackOrder() {
        trackOrderLink.click();
    }

		
	}

