package com.OHRM.qa.pages;

import java.io.BufferedReader;
import java.io.FileReader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OHRM.qa.Base.TestBase;
import com.OHRM.qa.Util.TestUtil;

public class PIMpage extends TestBase
{
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PIM;
	
	@FindBy(id="empsearch_id")
	WebElement searchBox;
	
	@FindBy(id="searchBtn")
	WebElement Search;
	
	@FindBy(id="resultTable")
	WebElement table;
	
	
	
	
	
	public PIMpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateTable() throws Throwable
	{
		FileReader fr = new FileReader("./OrangeHRM_POM/CaptureData/capData.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		
		PIM.click();
		searchBox.sendKeys();
	}
	
	
	
	
}
