package com.OHRM.qa.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OHRM.qa.Base.TestBase;
import com.OHRM.qa.Util.ExcelUtils;
import com.OHRM.qa.pages.AddEmployee;
import com.OHRM.qa.pages.HomePage;
import com.OHRM.qa.pages.LoginPage;
import com.OHRM.qa.pages.PIMpage;

public class AddEmp_Test extends TestBase
{
	HomePage hmPage;
	LoginPage lgin;
	PIMpage p;
	AddEmployee adEmp;
	ExcelUtils excel;
	public AddEmp_Test()
	{
		super();
	}
	
	@BeforeMethod 
	public void setup() throws Throwable
	{
		initialization();
		lgin = new LoginPage();
		p = new PIMpage();
		adEmp= new AddEmployee();
		
		hmPage=lgin.login(input.getProperty("username"), input.getProperty("password"));
		
		hmPage.addEmpLink();
	}
	@Test(priority=1)
	public String adEmp_tittle()
	{
		String tittle =  adEmp.ADTittle();
		return tittle;
	}
	@Test(priority=2)
	public boolean verifyLogo()
	{
		Boolean flag = adEmp.logo();
		return flag;
	}
	@DataProvider
	public Object[][] getEmpData()
	{
		@SuppressWarnings("static-access")
		Object data[][] = excel.getTestData("OrangeHRM");
		return data;
				
	}
	
	
		@Test(priority=3,dataProvider="getEmpData")
	public void verifyAddEmp(String fnme, String mnme, String lnme) throws Throwable
	{
	
		//adEmp.addEmploye("Varma", "Teja", "Ravi");
			adEmp.addEmploye(fnme, mnme, lnme); 
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
	
}
