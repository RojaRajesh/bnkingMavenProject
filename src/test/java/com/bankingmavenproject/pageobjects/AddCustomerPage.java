package com.bankingmavenproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath="//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement AddNewCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement AddCustomerName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement AddGender;
	
	@FindBy(id="dob")
	@CacheLookup
	WebElement AddDob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement Address;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement telephoneno;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement emailid;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@value=\"Submit\"]")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath="//input[@value=\"Reset\"]")
	@CacheLookup
	WebElement reset;
	
	public void ClickNewCustomer()
	{
		AddNewCustomer.click();
	}
	public void CustomerName(String cname)
	{
		AddCustomerName.sendKeys(cname);
	}
	public void Gender(String cgender)
	{
		 AddGender.click();
	}
	public void DOB(String mm,String dd,String yy)
	{
		AddDob.sendKeys(String.valueOf(mm));
		AddDob.sendKeys(String.valueOf(dd));
		AddDob.sendKeys(String.valueOf(yy));
		
	}
	public void address(String caddress)
	{
		 Address.sendKeys(caddress);
	}
	public void city(String ccity)
	{
		city.sendKeys(ccity);
	}
	public void state(String cstate)
	{
		state.sendKeys(cstate);
	}
	public void pincode(String pinno )
	{
		pincode.sendKeys(String.valueOf(pinno));
	}
	public void mobilenum(String mobile)
	{
		telephoneno.sendKeys(String.valueOf(mobile));
	}
	public void emailid(String email)
	{
		 emailid.sendKeys(email);
	}
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void submit()
	{
		submit.click();
	}
	public void reset()
	{
		reset.click();
	}

}
