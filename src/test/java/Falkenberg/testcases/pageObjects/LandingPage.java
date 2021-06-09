package Falkenberg.testcases.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public  LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By signin=By.cssSelector("a[href *='sign_in']");
	
	By title=By.cssSelector("div[class='text-center'] h2");
	By navigationBar=By.cssSelector(".navbar-collapse.collapse");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LoginPage getLogin()
	{
		
		driver.findElement(signin).click();
		//= new LoginPage(driver);
		return new LoginPage(driver);
	}

	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	public WebElement getPopUp()

	{

	return driver.findElement(popup);

	}
	public int getPopUpSize()

	{

	return driver.findElements(popup).size();

	}

	
}
