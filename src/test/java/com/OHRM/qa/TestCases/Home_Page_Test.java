package com.OHRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OHRM.qa.Base.TestBase;
import com.OHRM.qa.pages.HomePage;
import com.OHRM.qa.pages.LoginPage;

public class Home_Page_Test extends TestBase
{
	LoginPage lgin;
	HomePage hmpg;
	
	public Home_Page_Test()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		lgin = new LoginPage();
		hmpg = lgin.login(input.getProperty("username"), input.getProperty("password"));
	}
	@Test(priority=1)
	public void homePageTittle()
	{
		String hTittle = hmpg.verifyHomepageTittle();
		Assert.assertEquals(hTittle, "OrangeHRM", "Home page tittle not matched");
	}
	
	@Test(priority=2)
	public void veryfiyAdminPage() throws Throwable
	{
		hmpg.clickAdminLink();
	}
	
	@Test(priority=3)
	public void verifyPIMpage()
	{
		hmpg.clickPIMLink();
	}
	
	@Test(priority=4)
	public void verifyMyinfo()
	{
		hmpg.clickPIMLink();
	}
	
	@Test
	public void verifyLogout()
	{
		hmpg.clickLogout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
