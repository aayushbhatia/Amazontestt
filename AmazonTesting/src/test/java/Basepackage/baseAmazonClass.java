package Basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseAmazonClass {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	


	public baseAmazonClass() {
		
		try {
		
		FileInputStream file=new FileInputStream("C:\\Users\\bhati\\eclipse-workspace\\AmazonTesting\\src\\test\\java\\amazonfiles\\Config.properties");
		prop.load(file);
		
		}
		
	catch(IOException a) {
		a.printStackTrace();
	}
}
	
	
	public static void initiation() {
		
	String browsername= prop.getProperty("browser");

	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		
	
}
}
