package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
 WebDriver driver;
 
 public  BasePage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }
}

//it is creating for reuse the driver and the pagefactory method
//and it is a parent class and super keyword is used to invoke diver method from the parent class to child class