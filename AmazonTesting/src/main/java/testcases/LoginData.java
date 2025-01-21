package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginData {

	public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
//open url and enter all valid details
		driver.get("https://www.amazon.ca");
		// enter new mobile number
		driver.findElement(By.className("nav-action-signin-button")).click();
		driver.findElement(By.id("ap_email_login")).sendKeys("aayushbhatiaca@gmail.com");// enter existing email
		driver.findElement(By.className("a-button-text a-text-center")).click(); //click on continue
		driver.findElement(By.id("ap_password")).sendKeys("Abhi@2502");
		driver.findElement(By.id("continue")).click(); 
	}

}
