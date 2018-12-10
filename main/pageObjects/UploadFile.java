package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UploadFile {

	
	public WebDriver driver;
	
public UploadFile(WebDriver driver) {
		
		
		this.driver=driver;
		
	}
	
	By username=By.id("userName");
	By password=By.id("password");
	By login=By.id("login");
	By search=By.xpath("//div[@class='uiTextField uiField  uiIconField']");
	
	By projectselector=By.xpath("//span[@class='projectChanger-container']");
	By hotelVIPResort=By.xpath("//div[@class='uiPanel projectChanger-list projectChanger-overflow']/div[@title='Hotel VIP Resort & Spa']");
	
	By documents=By.xpath("//div[@class='bicon ic-DOC']"); 
	
	By uploadNewDoc=By.xpath("//div[text()='Upload a New Document']");
	
	By uploadBtn=By.id("btnUploadDocument");
	
	
	
	By documentNum=By.xpath("//div/input[@title='Document Number']");
	
	By revision=By.xpath("//div/input[@title='Document Revision Number/Letter']");
	
	By title=By.xpath("//div/input[@title='Title']");
	
	By typeSelection=By.xpath("//select[@title='Type']");
	
	
	By statusSelect=By.xpath("//select[@title='Current status of this document']");
	
	By attributeOneSelect=By.xpath("//div[@title='Attribute 1 List']");
	
	By attributeValueSelect=By.xpath("//div[@id='attribute1_0_bidi']//select[@multiple='multiple']/option[@value='Administration']");
	
	
	By addToList=By.xpath("//div[@class='uiBidi-actions']/button[@title='Add item to list']");
	
	
	By okButton=By.xpath("//button[@title='OK']");
	
	
	By fileUploadBtn=By.id("clickToUpload");
	
	By selectedFile=By.xpath("//div[text()='test.pdf']");
	
	
	By docUploadSuccess=By.xpath("//span[text()='Document Uploaded Successfully']");
	
	By docNumberSuccess= By.xpath("//div[@id='regSuccess']//li[@class='message success']//b");
	
	By msgClose = By.xpath("//button[@id='regSuccessPanel-cancel']//div[text()='Close']");
	
	By docRegisterLink = By.xpath("//div[text()='Document Register']");
	
	By searchField=By.xpath("//div[@class='superSearchInput']/input[@id='searchQuery']");
	
	By searchResultsBtn = By.xpath("//button[@id='btnSearch_page']");
	
	
	
	




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

public WebElement projectselector()
{
	return driver.findElement(projectselector);
}


public WebElement hotelVIPResort()
{
	return driver.findElement(hotelVIPResort);
}



public WebElement documents()
{
	return driver.findElement(documents);
}

public WebElement uploadNewDoc()
{
	return driver.findElement(uploadNewDoc);
}

public WebElement uploadBtn()
{
	return driver.findElement(uploadBtn);
}

public WebElement documentNum()
{
	return driver.findElement(documentNum);
}

public WebElement revision()
{
	return driver.findElement(revision);
}

public WebElement title()
{
	return driver.findElement(title);
}
public WebElement typeSelection()
{
	return driver.findElement(typeSelection);
}
public WebElement statusSelect()
{
	return driver.findElement(statusSelect);
}

public WebElement attributeOneSelect()
{
	return driver.findElement(attributeOneSelect);
}
public WebElement attributeValueSelect()
{
	return driver.findElement(attributeValueSelect);
}
public WebElement addToList()
{
	return driver.findElement(addToList);
}
public WebElement okButton()
{
	return driver.findElement(okButton);
}
public WebElement fileUploadBtn()
{
	return driver.findElement(fileUploadBtn);
}

public WebElement selectedFile()
{
	return driver.findElement(selectedFile);
}

public WebElement docUploadSuccess()
{
	return driver.findElement(docUploadSuccess);
}

public WebElement docNumberSuccess()
{
	return driver.findElement(docNumberSuccess);
}

public WebElement msgClose()
{
	return driver.findElement(msgClose);
}


public WebElement docRegisterLink()
{
	return driver.findElement(docRegisterLink);
}

public WebElement searchField()
{
	return driver.findElement(searchField);
}

public WebElement searchResultsBtn()
{
	return driver.findElement(searchResultsBtn);
}




/*public void navigateToEmail() {
	driver.findElement(emailSection).click();
	driver.findElement(blankEmail).click();
	
	
}*/


public void selectfromDropDown(String docType)
{
	
	
	Select dropdown= new Select(driver.findElement(typeSelection));
	dropdown.selectByVisibleText(docType);
	System.out.println("Drop down selection complete "+ docType);
}

public void selectstatus(String statusType)
{
	
	
	Select dropdown= new Select(driver.findElement(statusSelect));
	dropdown.selectByVisibleText(statusType);
	System.out.println("Drop down selection complete "+ statusType);
}

}