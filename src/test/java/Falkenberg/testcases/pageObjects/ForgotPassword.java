package Falkenberg.testcases.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
public WebDriver driver;
	
	public  ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Email=By.id("user_email");
	By sendMeInstructions=By.cssSelector(".btn.btn-primary.btn-md.login-button");
	
	
	
	public WebElement getEmail()
	{
		return driver.findElement(Email);
		
	}
	
	public WebElement getSendMeInstructions()
	{
		return driver.findElement(sendMeInstructions);
		
	}
	
	
	
	
}
