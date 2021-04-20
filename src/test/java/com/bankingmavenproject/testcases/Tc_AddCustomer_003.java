package com.bankingmavenproject.testcases;



import java.io.IOException;

import com.bankingmavenproject.pageobjects.AddCustomerPage;
import com.bankingmavenproject.pageobjects.LoginPage;

import junit.framework.Assert;

public class Tc_AddCustomer_003 extends BaseClass
{
	public void AddCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setUserPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage acp=new AddCustomerPage(driver);
		acp.ClickNewCustomer();
		acp.CustomerName("roja");
		acp.Gender("female");
		acp.DOB("09", "30", "1995");
		acp.address("Banglore");
		acp.city("Banglore");
		acp.state("karnataka");
		acp.pincode("583101");
		acp.mobilenum("987654321");
		String email=randomstring()+"@gmail.com";
		acp.emailid(email);
		acp.setpassword("abcdef");
		acp.submit();
		acp.reset();
		boolean res=driver.getPageSource().contains("Customer registered successfully");
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			screenshot(driver,"addnewcustomer");
			Assert.assertTrue(false);
		}
	

}
}
