package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("*****starting TC002_LoginTest*****");
try {
		
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.setLogin();

MyAccountPage mcc=new	MyAccountPage(driver);
boolean targetPage=mcc.isMYAccountPageExists();
Assert.assertTrue(targetPage);
	}
	catch(Exception e){
		Assert.fail();
	}
logger.info("****finished TC002_LoginTest*******");
	}
	
}
