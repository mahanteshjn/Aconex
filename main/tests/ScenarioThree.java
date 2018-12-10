package tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import pageObjects.Email;
import resources.base;

public class ScenarioThree extends base{
  
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	// Scenario Three
	@Test
	public void sendEmail() throws IOException, InterruptedException
	{

		 String Username=prop.getProperty("username");
		 String Password=prop.getProperty("password");
		 String emailType=prop.getProperty("emailType");
		 String emailSubjectLine=prop.getProperty("subject");
		 
		 driver.get(prop.getProperty("url"));
		 Email em=new Email(driver);
			
		 em.getUsername().sendKeys(Username);
		 em.getPassword().sendKeys(Password);
		 em.getLogin().click();
		
		
		System.out.println("User logged in");
	
		 Assert.assertTrue(em.getSearchField().isDisplayed()); // Indicates successful login as search field is displayed
		
		//Navigate to Blank mail section
		em.navigateToEmail();
		
		driver.switchTo().frame("frameMain");
		
		System.out.println("User is in email section");
		Assert.assertTrue(em.getsendButton().isDisplayed()); //Verify presence of send button
		
		System.out.println("Email send button displayed");
		em.selectEmailType(emailType); //Select email type as Transmittal
		
		System.out.println("Selecting email type");
		em.getemailTo().sendKeys("lewis");
		em.getemailTo().sendKeys(Keys.RETURN);
		
		
		em.getsubject().sendKeys(emailSubjectLine); //Enter subject line
		em.getsendButton().click(); //Click on send button
		
		
		driver.switchTo().defaultContent();
		
		System.out.println("Switch to frame of sent email window");
		driver.switchTo().frame("frameMain");
		
		
		Assert.assertTrue(em.getdocNumEmail().isDisplayed()); // Verify that reference number field is available
		System.out.println("The reference number is " +em.getdocNumEmail().getText()); // Print reference number
		
			
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	
	
	
}
