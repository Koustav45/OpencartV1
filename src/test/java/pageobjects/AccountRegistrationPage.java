package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
WebDriver driver;
public  AccountRegistrationPage(WebDriver driver) {
	super(driver);
}

@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lasttname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirmpassword']")
WebElement txtConfirmpassword;

@FindBy(xpath="//input[@name='input-agree']")
WebElement chkdPolicy;

@FindBy(xpath="//button[normalize-space()='Continue']")
WebElement bttnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created']")
WebElement msgConfirmation;

public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
}
public void setlasttName(String lname) {
	txtLastname.sendKeys(lname);
}
public void setEmail(String email) {
	txtEmail.sendKeys(email);
}
public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);
}
public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}
public void setConfirmpassword(String pwd) {
	txtConfirmpassword.sendKeys(pwd);
}
public void setPrivacypolicy() {
	chkdPolicy.click();
}	
public void setContinue() {
	bttnContinue.click();
}	

 
public String getConfirmationMsg() {
	try {
		return(msgConfirmation.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
	}
}


}