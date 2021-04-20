package com.bankingmavenproject.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bankingmavenproject.utilities.ReadConfig;


public class BaseClass 
{
	
	
	ReadConfig rc=new ReadConfig();
	public String baseUrl=rc.getApplicationUrl();
	public String username=rc.getUserName();
	public String password=rc.getPassword();
	public static WebDriver driver;
	 public static Logger logger;
	
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
	//System.getproperty is used to redirect the file
		 logger=Logger.getLogger("Banking");
		 PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("Chrome"))
		{
	System.setProperty("webdriver.chrome.driver",rc.getChrome());
	driver=new ChromeDriver();
		}
		else
		
			if(br.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver",rc.getie());
				driver=new InternetExplorerDriver();	
			}
			else
				if(br.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver",rc.getfirefox());
					driver=new FirefoxDriver();
				}
		
	
    
	driver.get("baseUrl");
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void screenshot( WebDriver driver,String tname) throws IOException
	  
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"//screenshot//"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot is taken");
	}
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(10);
		return generatedstring;
		
	}
	public static String radomnum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(10);
		return generatedstring2;
	}


	

}
