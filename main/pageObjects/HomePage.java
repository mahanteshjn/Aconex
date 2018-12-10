package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	
	public WebDriver driver;
	
	By search=By.xpath("//div[@class='uiTextField uiField  uiIconField']");
	By password=By.id("password");
	By login=By.id("login");
	
	
	
	
	public HomePage(WebDriver driver) {
		
		
		this.driver=driver;
		
	}




	public WebElement getSearchField()
	{
		return driver.findElement(search);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	
}
