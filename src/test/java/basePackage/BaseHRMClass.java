package  basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.ScreenshotException;

import utility.TimeUtils;

public class BaseHRMClass {
//browser info   WebDriver driver=new FirefoxDriver();
	//url info
	//username and password
	
	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	
	//Step 1
	public BaseHRMClass()
	{
	try {
	FileInputStream file = new FileInputStream("C:\\Users\\dmathew\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
	prop.load(file);
	
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException a)
	{
		a.printStackTrace();
	}
	}
//Step 2 
	public static void initiate()
	
	{
		//if browser=chrome webdriver.chrome.driver
		//elseif(browser=firefox)
	//  webDriver.gecko
		//maximize pageload,implicit,getting url
		
	String browsername=	prop.getProperty("browser");
	
if(browsername.equals("Firefox")) 
{		

	
	driver=new FirefoxDriver(); 
	}
	else if (browsername.equals("Chrome")) {
		System.setProperty("webdriver.chromedriver", "chromedriver.exe");	
	driver=new ChromeDriver();
	
	
	}
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));	



	}
	
	public static void screenshots(String Filename) throws InterruptedException
	{
		Thread.sleep(2000);
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	

	try
	{
	FileUtils.copyFile(file,new File("C:\\Users\\dmathew\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
	
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	}
}
	
	
	
	 
	
