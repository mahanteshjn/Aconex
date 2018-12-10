package tests;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.UploadFile;
import resources.base;

public class ScenarioOne extends base{
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	@Test
	
	/*Scenario One*/
	public void fileUploadVerify() throws IOException, InterruptedException
	{

		String Username=prop.getProperty("username");
		String Password=prop.getProperty("password");
		

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		
		//driver.get(prop.getProperty("filePath")); // Get file path to be uploaded
		
		UploadFile lp=new UploadFile(driver);
		
		lp.getUsername().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		
		
		lp.getLogin().click();
		
		
		
		Assert.assertTrue(lp.getSearchField().isDisplayed()); // Indicates successful login as search field is displayed
		
		// Select project & navigate to Hotel VIP Resort
		
		lp.projectselector().click();
		lp.hotelVIPResort().click();
		
		// Navigate to Document section to upload file
		
		lp.documents().click();
		
		lp.uploadNewDoc().click();
		
		
		// Switch to frame to get details inside file upload screen
		driver.switchTo().frame("frameMain");
		Assert.assertTrue(lp.uploadBtn().isDisplayed()); // Verify file upload button is present to ensure user is in file upload page
		System.out.println("In file upload screen");
		
		long id=(long)(Math.random()*100000 + 321450000000L);// Generate 12 digit random number & store in a variable
		String DocNum= Long.toString(id);
		System.out.println("Document number is " + DocNum);
		
		// Enter manadatory fields
		lp.documentNum().sendKeys(DocNum);
		lp.revision().sendKeys("Revised");
		lp.title().sendKeys("SLA");
		
		
		
		lp.selectfromDropDown("Contract");
		lp.selectstatus("Approved");
		
		
		//Attribute selection
		Assert.assertTrue(lp.attributeOneSelect().isDisplayed());
		lp.attributeOneSelect().click();
		lp.attributeValueSelect().click();
		lp.addToList().click();
		Assert.assertTrue(lp.okButton().isDisplayed());
		lp.okButton().click();
		
		
		System.out.println("File upload");
		//file upload
		
		
		Assert.assertTrue(lp.fileUploadBtn().isDisplayed());
		
		Actions actions = new Actions(driver);
		actions.moveToElement(lp.fileUploadBtn());
		actions.click();
		actions.sendKeys("C:\\workspace\\Matrix\\Aconex\\FileToUpload\\test.pdf");
		actions.build().perform();
		
		
		lp.uploadBtn().click();
		
		System.out.println("File upload completed");
		
		Assert.assertTrue(lp.docNumberSuccess().isDisplayed());
		
		String docNumberUploaded = lp.docNumberSuccess().getText();
		
		System.out.println("Uploaded document number is "+ docNumberUploaded);
		
		Assert.assertSame(DocNum,lp.docNumberSuccess().getText()); // Verify that doc number is same as entered earlier
		lp.msgClose().click();
		
		// Go to document register
		driver.switchTo().defaultContent();
		System.out.println("Go to document register page");
		lp.documents().click();
		lp.docRegisterLink().click();
		
		driver.switchTo().frame("frameMain");
		System.out.println("Search for the document");
		Assert.assertTrue(lp.searchField().isDisplayed());
		lp.searchField().sendKeys(DocNum);
		lp.searchResultsBtn().click();
		
		
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	
	
	}


  
}
