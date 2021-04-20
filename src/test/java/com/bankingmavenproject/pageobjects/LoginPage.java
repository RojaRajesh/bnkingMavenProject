package com.bankingmavenproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
WebDriver ldriver;//creating the object of the webdriveer and iitiating to the localdriver

public LoginPage(WebDriver rdriver)//creating a constructor of the class and  naming to the remote driver
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
 @FindBy(name="uid")//it i used for uername
 @CacheLookup
 WebElement txtusername;
 @FindBy(name="password")
 @CacheLookup//@CacheLookup is a very important and overlooked annotation that can help us make our tests run faster.
 WebElement txtpassword;
 @FindBy(name="btnLogin")
 @CacheLookup
 WebElement btnlogin;
 @FindBy(xpath="//a[@href=\"Logout.php\"]")
 @CacheLookup
 WebElement logout;
 
 public void setUserName(String uname)
 {
	 txtusername.sendKeys(uname);
 }
 
 public void setUserPassword(String pwd)
 {
	 txtpassword.sendKeys(pwd);
 }
 public void clickSubmit()
 {
	 btnlogin.click();
 }
 public void clicklogout()
 {
	 logout.click();
	 
 }

}
