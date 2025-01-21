package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	 WebDriver driver;

	    // Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	  



		@FindBy(id = "ap_email")
	    WebElement emailField;

		@FindBy(css="#continue > span > input")
	    WebElement cButton;
	    @FindBy(id = "ap_password")
	    WebElement passwordField;

	    @FindBy(id = "signInSubmit")
	    WebElement loginButton;

	    @FindBy(id = "auth-keep-me-signed-in")
	    WebElement keepMeSignedInCheckbox;

	    @FindBy(id = "auth-error-message-box")
	    WebElement errorMessage;

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }

	    public void conButton() {
	        cButton.click();
	    }
	        
	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        loginButton.click();
	    }

	    public void selectKeepMeSignedIn() {
	        if (!keepMeSignedInCheckbox.isSelected()) {
	            keepMeSignedInCheckbox.click();
	        }
	    }

	    public String getErrorMessage() {
	        return errorMessage.getText();
	    }
	 
}
