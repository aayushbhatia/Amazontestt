package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Existingemail {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
//open url and enter all valid details
		driver.get("https://www.amazon.ca/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		// enter new mobile number
		driver.findElement(By.id("ap_email_login")).sendKeys("aayushbhatiaca@gmail.com");// enter existing email
		driver.findElement(By.className("a-button-text a-text-center")).click(); //click on continue
		driver.findElement(By.id("ap_customer_name")).sendKeys("aayush"); //enter cx name
		driver.findElement(By.id("ap_password")).sendKeys("Abnf@8765");
		driver.findElement(By.id("ap_password_check")).sendKeys("Abnf@8765");
		driver.findElement(By.id("continue")).click(); 
	
		
		
		//driver.close(); // for close the browser

	}
	}


