package com.bankingmavenproject.testcases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankingmavenproject.pageobjects.LoginPage;
import com.bankingmavenproject.utilities.XUtils;

public class Tc_LoginTest_002 extends BaseClass
{
@Test(dataProvider="logindata")

public void loginddt(String username,String pwd)
{
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("user name is provided");
	lp.setUserPassword(pwd);
	logger.info("password is provided");
	lp.clickSubmit();
	logger.info("click on the login buttoon");
	if(isAlertPresent()==true)//for failed codition
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("Login failed");
		
		
	}
	else
	{
		Assert.assertTrue(true);
		lp.clicklogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
}
public boolean isAlertPresent()
{
	try {
		
	
	driver.switchTo().alert();
	return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
}


@DataProvider(name="logindata")
String[][] getData() throws IOException
{
	String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\bankingmavenproject\\utilities\\XUtils.java";
	int rownum=XUtils.getrowcount(path, "Sheet1");
	int cellnum=XUtils.getcellcount(path,"sheet1", 1);
	String logindata[][]=new  String[rownum][cellnum];
	for(int i=1;i<=rownum;i++)
	{
		for(int j=1;j<=cellnum;j++)
		{
			logindata[i-1][j]=XUtils.getcelldata(path, "sheet1", i, j);
		}
	}
	return logindata;
	
}

}
