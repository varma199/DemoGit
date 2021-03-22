package com.OHRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OHRM.qa.Base.TestBase;
import com.OHRM.qa.pages.HomePage;
import com.OHRM.qa.pages.LoginPage;

public class Login_Page_Test extends TestBase
{
	LoginPage lgin;
	HomePage hmpg;
	public Login_Page_Test()
	{
		super();	//it will call super class(TestBase class)  constructor (for initialisation our properties )
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		lgin = new LoginPage();
	}
	@Test(priority=1)
	public void loginPage_Tittle_Test() throws Throwable
	{
		String tittle = lgin.validateLoginPageTittle();
		Assert.assertEquals(tittle, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void loginpage_Logo_Test()
	{
		boolean flag = lgin.validateOHRM_Image();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void login_Test()
	{
		hmpg =lgin.login(input.getProperty("username"), input.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
