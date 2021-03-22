package com.OHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OHRM.qa.Base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement admin;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PIM;
	
	@FindBy(id="menu_pim_addEmployee")
	WebElement AdEmp;
	
	@FindBy(id="menu_pim_viewMyDetails")
	WebElement MyInfo;
	
	@FindBy(id="welcome")
	WebElement wcome;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTittle()
	{
		return driver.getTitle();
	}
	
	public Adminpage clickAdminLink() throws Throwable
	{
		admin.click();
		return new Adminpage();
	}
	
	public PIMpage clickPIMLink()
	{
		PIM.click();
		return new PIMpage();
	}
	
	public MyInfoPage clickMyInfoLink()
	{
		MyInfo.click();
		return new MyInfoPage();
	}
	
	public LoginPage clickLogout()
	{
		wcome.click();
		logout.click();
		return new LoginPage();
	
	}
	
	public void addEmpLink()
	{
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();
		AdEmp.click();
	}
	
}