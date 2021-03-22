package com.OHRM.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.OHRM.qa.Util.TestUtil;

public class TestBase
{
	public static WebDriver driver;
	public static Properties input;
	
	
	
	public TestBase() 
	{
		try
		{
			input = new Properties();
			 FileInputStream fi = new FileInputStream("E:\\workSpace2\\OrangeHRM_POM\\src\\main\\java\\com\\OHRM\\qa\\Config\\ config.properties");
			 input.load(fi);

		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static void initialization()
	 {
		 String browser=input.getProperty("browser");
		 if (browser.equalsIgnoreCase("chrome"))
		 {
			  System.setProperty("webdriver.chrome.driver", "E:\\workSpace2\\OrangeHRM_POM\\jar\\chromedriver.exe");
			  driver = new ChromeDriver();  
		}
		 else if (browser.equalsIgnoreCase("firefox"))
		 {
			System.setProperty("webdriver.gecko.driver", "E:\\workSpace2\\OrangeHRM_POM\\jar\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		 else {
			System.out.println("Browser not matched");
		}
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 
		 driver.get(input.getProperty("url"));
		   
	 }
	 
	 
	 
 }
