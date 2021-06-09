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


public class ValidatTitle extends Base{
	public WebDriver driver;
	public Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		
		driver=initializeDriver();
	driver.get(prop.getProperty("Url"));
		
	}
	
	@Test
	public void basePageValidation() throws IOException
	{
		
		LandingPage lp= new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("validated page title");
	
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
