package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;
import testbase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
	
	logger.info("*****Starting AccountRegistrationTest*******");
	try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****clicked on my account link****");
		
		hp.clickRegister();
		logger.info("****clicked on register link****");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("****providing customer details***");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setlasttName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmpassword(password);
		regpage.setPrivacypolicy();
		regpage.setContinue();
		
		logger.info("validating expected message");
		String cnfmsg=regpage.getConfirmationMsg();
		if(cnfmsg.equals("Your Account Has Been Created")) 
	{
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
	//	Assert.assertEquals(cnfmsg,"Your Account Has Been Created");
	}
	catch(Exception e){
		
		Assert.fail();
	}
	logger.info("****test finished*****");	
	}

}
