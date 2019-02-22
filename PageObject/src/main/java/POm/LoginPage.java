package POm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	@FindBy(how=How.ID,using="user_login")WebElement user;
	
	@FindBy(how=How.NAME,using="pwd")WebElement pass;
	
	@FindBy(how=How.ID,using="wp-submit")WebElement button;
	
	
	public void verify_login(String usId,String passId) {
		
		user.sendKeys(usId);
		
		pass.sendKeys(passId);
		
		button.click();
	}
	
	
	
	
	
	
	
	
	
}
