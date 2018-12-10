package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;
	
	By username=By.id("userName");
	By password=By.id("password");
	By login=By.id("login");
	By search=By.xpath("//div[@class='uiTextField uiField  uiIconField']");
	By projectselector=By.xpath("//span[@class='projectChanger-container']"); 
	By worldgamesproj=By.xpath("//div[@class='uiPanel projectChanger-list projectChanger-overflow']/div[@title='The World Games']");
	By workflows=By.xpath("//div[@class='bicon ic-WORKFLOW']");
	By assignedToOrg=By.xpath("//div[@id='nav-bar-WORKFLOW-SavedSearches']/div[text()='Assigned to my organization']");
	By resultcount=By.xpath("//div[@id='numResults']/b[2]");
	
	
	
	public LoginPage(WebDriver driver) {
		
		
		this.driver=driver;
		
	}




	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getSearchField()
	{
		return driver.findElement(search);
	}
	
	public WebElement getprojselector()
	{
		return driver.findElement(projectselector);
	}
	
	public WebElement getWorldGameProj()
	{
		return driver.findElement(worldgamesproj);
	}
	public WebElement getworkflows()
	{
		return driver.findElement(workflows);
	}
	public WebElement getAssigned()
	{
		return driver.findElement(assignedToOrg);
		
	}
	
	public WebElement getresults()
	{
		return driver.findElement(resultcount);
	}
	
	
}
