package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements, driver.findelement(by. 
    
    @FindBy(id = "ap_email")
    WebElement emailField;  // Email field
    
    @FindBy(id = "ap_customer_name") // Name field
    WebElement nameField;
 

  @FindBy(id = "ap_password")WebElement passwordField;
  @FindBy(id="ap_password_check")WebElement passwordFieldCheck;

   @FindBy(id = "continue") // Register button
    WebElement registerButton;

   
   @FindBy(id = "auth-error-message-box") // Error message
    WebElement errorMessage;

    // Methods
    public void enterName(String name) {
        nameField.sendKeys(name);
    }

   public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    
    public void enterPasswordCheck(String password) {
        passwordField.sendKeys(password);
    }

      public void clickRegisterButton() {
        registerButton.click();
    }

     public String getErrorMessage() {
        return errorMessage.getText();
    }
}

