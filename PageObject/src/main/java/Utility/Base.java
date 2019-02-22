package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	public WebDriver driver;
	
	@BeforeMethod
	public void test() throws IOException {
		
		FileInputStream fis=new FileInputStream("./Source/config.properties");
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
		if(prop.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","/home/manjit/Downloads/chromedriver_linux64/chromedriver");
			
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","/home/manjit/Downloads/geckodriver-v0.21.0-linux64/geckodriver");
			
			driver=new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void TearDown() throws InterruptedException {
		
	 Thread.sleep(3000);
	 
	 driver.close();
	}
}
