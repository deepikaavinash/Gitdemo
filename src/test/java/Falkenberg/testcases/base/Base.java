package Falkenberg.testcases.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public  Logger log=LogManager.getLogger(Base.class.getName());
	
	public WebDriver initializeDriver() throws IOException
	{
	prop= new Properties();
	//FileInputStream fis= new FileInputStream("G:\\udemy-liveprojects\\E2EProject\\src\\test\\resources\\properties\\data.properties");
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	//String browserName=System.getProperty("browser");
	log.info("chrome initialized");
	
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		if(browserName.contains("headless")) {
			options.addArguments("headless");
		}
		
		driver=new ChromeDriver(options);
	}
	else if(browserName.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	else if(browserName.equalsIgnoreCase("IE"))
	{
		System.setProperty("webDriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
		//driver=new IEDriverServer();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	
	}
	
	public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
	    File source=ts.getScreenshotAs(OutputType.FILE);
	    String destination =System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+testMethodName+".png";
	    FileUtils.copyFile(source,new File( destination));
	return destination;
	}
	

}
