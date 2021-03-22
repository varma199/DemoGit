package com.OHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OHRM.qa.Base.TestBase;

public class AddEmployee extends TestBase
{
	
	@FindBy(xpath="//div[@id='branding']//a//img")
	WebElement AdEmpLogo;
	
	@FindBy(id="firstName")
	WebElement Fname;
	
	@FindBy(id="middleName")
	WebElement Mname;
	
	@FindBy(id="lastName")
	WebElement Lname;
	
	@FindBy(id="employeeId")
	WebElement EmpNum;
	
	@FindBy(id="btnSave")
	WebElement saveBtn;
	
	
	
public AddEmployee()
{
	PageFactory.initElements(driver, this);
}

public boolean logo()
{
	return AdEmpLogo.isDisplayed();
}

public String ADTittle()
{
	return driver.getTitle();
}
public void addEmploye(String fnme, String mnme, String lnme) throws Throwable
{
	Fname.sendKeys(fnme);
	Mname.sendKeys(mnme);
	Lname.sendKeys(lnme);
	saveBtn.click();
	
	
}


}
