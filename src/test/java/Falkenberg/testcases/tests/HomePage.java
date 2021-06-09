package Falkenberg.testcases.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Falkenberg.testcases.base.Base;
import Falkenberg.testcases.pageObjects.ForgotPassword;
import Falkenberg.testcases.pageObjects.LandingPage;
import Falkenberg.testcases.pageObjects.LoginPage;

public class HomePage extends Base {
	public WebDriver driver;
	public Logger log=LogManager.getLogger(Base.class.getName());
	//Base b=new Base();
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	driver.get(prop.getProperty("Url"));
	log.debug("url is opened in browser");
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException, InterruptedException
	{
		
		driver.get(prop.getProperty("Url"));
		driver.manage().window().maximize();
		log.debug("url is opened again ");
		LandingPage lp= new LandingPage(driver);
		Thread.sleep(6000);
		if(lp.getPopUpSize()>0)
		{
			lp.getPopUp().click();
		}
		/*String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;
		// get all window handles
		Set<String> handles = driver.getWindowHandles();
	System.out.println(handles.size());
		
		Iterator<String> iterator = handles.iterator();
		
		
	while(iterator.hasNext()){
		    subWindowHandler = iterator.next();
		    if(!parentWindowHandler.equalsIgnoreCase(subWindowHandler))			
            {    		
		    driver.switchTo().window(subWindowHandler);
			lp.getPopUp().click();
            }
			
		}
		    driver.switchTo().window(parentWindowHandler); */
	
		    LoginPage logpage=lp.getLogin();
		log.debug("login button is clicked");
		
		
		log.info("entered login page");
		logpage.getEmail().sendKeys(Username);
		logpage.getPassword().sendKeys(Password);
		//String text;
		//System.out.println(Text);
		logpage.getLogin().click();
		log.info("submit button is clicked in login page");
		Thread.sleep(2000);
		ForgotPassword fp=logpage.getForgotPsw();
		fp.getEmail().sendKeys("asd");
		fp.getSendMeInstructions().click();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="abc@gmail.com";
		data[0][1]="abc";
		log.info("entered 1st set of data");
	   // data[0][2]="restricted User";
	    
	    data[1][0]="restricteduser@qw.com";
	    data[1][1]="456788";
	    log.info("entered 2st set of data");
	   	 //data[1][2]="non restricted user";
	   	 return data;
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
