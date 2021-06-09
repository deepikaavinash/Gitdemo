package Falkenberg.testcases.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Falkenberg.testcases.base.Base;
import Falkenberg.testcases.pageObjects.LandingPage;

public class ValidateNavigationBar extends Base{
	
	public WebDriver driver;
	public Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	driver.get(prop.getProperty("Url"));
		
	}
	
	@Test
	public void basePageNavigationBar() throws IOException
	{
	
	
		LandingPage lp= new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("validated page navigation bar");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
