package pompackage;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass
{ 
	
	  

	
	
//object repository
	@FindBy(name="username") WebElement Username;
	 
	 
	  @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	  WebElement Password;
	  
	  @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement Loginbtn;
	 
	
	//initiate page elements
	public PomLogin() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void typeusername(String name)
	{
		Username.sendKeys(name);
	}
	public void typepassword(String pass)
	{
	Password.sendKeys(pass);
}
	
public void clickbtn()	{

Loginbtn.click();

}
public String verify()
{
	return driver.getTitle();
}}