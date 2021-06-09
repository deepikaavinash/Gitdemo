package Falkenberg.testcases.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Falkenberg.testcases.base.Base;

public class LoginPage extends Base  {
	
public WebDriver driver;
	
	public  LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Email=By.id("user_email");
	By password=By.id("user_password");
	By login=By.cssSelector(".btn.btn-primary.btn-md.login-button");
	By forgotpsw=By.cssSelector("[href='password/new/index.php']");
	
	public WebElement getEmail()
	{
		return driver.findElement(Email);
		
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword getForgotPsw()
	{
		 driver.findElement(forgotpsw).click();
		 return   new ForgotPassword(driver);
		
		 
	}
	
}
