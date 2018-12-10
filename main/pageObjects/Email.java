package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Email {

	
	public WebDriver driver;
	
public Email(WebDriver driver) {
		
		
		this.driver=driver;
		
	}
	
	By username=By.id("userName");
	By password=By.id("password");
	By login=By.id("login");
	By search=By.xpath("//div[@class='uiTextField uiField  uiIconField']");
	By emailSection=By.xpath("//div[@class='bicon ic-CORRESPONDENCE']"); 
	By blankEmail=By.xpath("//div[@id='nav-bar-CORRESPONDENCE-CORRESPONDENCE-CREATEMAIL']");
	By emailTypes=By.id("Correspondence_correspondenceTypeID");
	
	By emailTo=By.cssSelector("input[name='SPEED_ADDRESS_TO']");
	By subject=By.cssSelector("input[id='Correspondence_subject']");
	By sendButton=By.cssSelector("button[id='btnSend']");
	By selectedRecipient=By.xpath("//tr[@id='TO_0']//strong");
	By docNumberEmail=By.xpath("//div[@class='mailThreadSlat-documentNo ng-binding']");
	
	




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

public WebElement getemailSection()
{
	return driver.findElement(emailSection);
}

public WebElement getblankEmail()
{
	return driver.findElement(blankEmail);
}

public WebElement getemailType()
{
	return driver.findElement(emailTypes);
}

public WebElement getemailTo()
{
	return driver.findElement(emailTo);
}

public WebElement getsubject()
{
	return driver.findElement(subject);
}

public WebElement getRecipient()
{
	return driver.findElement(selectedRecipient);
}



public WebElement getsendButton()
{
	return driver.findElement(sendButton);
}

public WebElement getdocNumEmail()
{
	return driver.findElement(docNumberEmail);
}
public void navigateToEmail() {
	driver.findElement(emailSection).click();
	driver.findElement(blankEmail).click();
	
	
}



public void selectEmailType(String emailType)
{
	
	System.out.println("Drop down selection");
	Select dropdown= new Select(driver.findElement(emailTypes));
	dropdown.selectByVisibleText(emailType);
	System.out.println("Drop down selection complete "+ emailType);
}

}