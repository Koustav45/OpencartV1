package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_DatadrivenLoginTest extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="Datadriven")
    public void verify_DatadrivenLoginTest(String email, String pwd, String exp) {
        logger.info("***** Starting TC003_DatadrivenLoginTest *****");

        try {
            // Navigate to login page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            // Perform login action
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);  // Use data from DataProvider
            lp.setPassword(pwd);  // Use data from DataProvider
            lp.setLogin();

            // Verify login result
            MyAccountPage mcc = new MyAccountPage(driver);
            boolean targetPage = mcc.isMYAccountPageExists();

            // Handle expected results (Valid/Invalid)
            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage) {
                    mcc.clickLogout();
                    Assert.assertTrue(true, "Login successful, as expected.");
                } else {
                    Assert.assertTrue(false, "Login failed, but was expected to succeed.");
                }
            } else if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage) {
                    mcc.clickLogout();  // Logout if somehow login was successful for invalid credentials
                    Assert.assertTrue(false, "Login successful, but was expected to fail.");
                } else {
                    Assert.assertTrue(true, "Login failed, as expected.");
                }
            }

        } catch (Exception e) {
            logger.error("Exception occurred during the test", e);
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }

        logger.info("***** Finished TC003_DatadrivenLoginTest *****");
    }
}
