package com.OHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OHRM.qa.Base.TestBase;

public class LoginPage extends TestBase
{
	  @FindBy(id="txtUsername")
	  WebElement username;
	  
	  @FindBy(id="txtPassword")
	  WebElement password;
	  
	  @FindBy(id="btnLogin")
	  WebElement login;
	  
	  @FindBy(xpath="//div[@id='divLogin']")
	 WebElement logo;
	  
	  
	  
	  public LoginPage() 
	  {
		  PageFactory.initElements(driver, this);
		  //this means current class object.  
	  }
	  
	  public String validateLoginPageTittle()
	  {
		  return driver.getTitle();
	  }
	public Boolean validateOHRM_Image()
	{
		return logo.isDisplayed();
	}
	public HomePage login(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
		
	}
	
}
