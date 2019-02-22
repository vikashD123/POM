package TestPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import DatafromExcel.ReadingData;
import POm.LoginPage;
import Utility.Base;

public class LoginTestpage extends Base{

	@Test(dataProvider="word",dataProviderClass=ReadingData.class)
	public void verifyLogin_Paage(String name,String password) {
		
		LoginPage obj=PageFactory.initElements(driver,LoginPage.class);
		
		obj.verify_login(name, password);
	}
}
