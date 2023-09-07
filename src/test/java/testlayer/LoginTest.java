package testlayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass

{
	PomLogin Log;
	public LoginTest()
	{
	
	super();
	}
	@BeforeMethod
	public void initsetup() throws InterruptedException 
	{

	initiate();
	screenshots("Login");
Log=new PomLogin();
		
	}
	@Test(priority=1)
	
	public void Title()
	{
		String actual=Log.verify();
		
		System.out.println(actual);
		Assert.assertEquals(actual,"OrangeHRM");
			
	}
	@DataProvider
	public Object[][] Details()
	{
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
	}
	
	
	@Test(priority=2, dataProvider="Details")
	public void Login(String name,String password) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		Log.typeusername(name);
		
		Log.typepassword(password);
		Thread.sleep(3000);
		//Log.typeusername(prop.getProperty("username"));
		//Log.typepassword(prop.getProperty("password"));
		//Log.clickbtn();
		//Thread.sleep(3000);
	}
	  @AfterMethod public void close() 
	  { 
		  driver.close(); 
		  }
	 
	
	{
}
}