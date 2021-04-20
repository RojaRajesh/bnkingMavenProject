package com.bankingmavenproject.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingmavenproject.pageobjects.LoginPage;

public class Tc_LoginTest_001 extends BaseClass
{

	

	@Test
	public void loginTest() throws IOException
	{
		//;//shift the code to base class
		logger.info("Etered the correct Url");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("username");
		logger.info("Entered a valid Username");
		lp.setUserPassword("password");
		logger.info("Enter a valid password");
		lp.clickSubmit();
		logger.info("click on login");
		
		if(driver.getTitle().equals("guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			screenshot( driver, "loginTes");
			Assert.assertTrue(false);
		}
		
	}

}
