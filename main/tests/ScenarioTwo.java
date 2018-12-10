package tests;

import java.io.IOException;


import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.base;

public class ScenarioTwo extends base{
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	@Test
	
	/*Scenario Two */
	public void workflowCount() throws IOException, InterruptedException
	{

		String Username=prop.getProperty("username");
		String Password=prop.getProperty("password");
		

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		
		LoginPage lp=new LoginPage(driver);
		
		lp.getUsername().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		
		
		lp.getLogin().click();
		
		
		
		Assert.assertTrue(lp.getSearchField().isDisplayed()); // Indicates successful login as search field is displayed
		
		// Select project & navigate to workflows --> assigned to my organization
		lp.getprojselector().click();
		lp.getWorldGameProj().click();
		lp.getworkflows().click();
		
		lp.getAssigned().click();
		
		// Switch to frame to get details inside workflow screen
		driver.switchTo().frame("frameMain");
		String resCount= lp.getresults().getText(); //Getting count from hidden input element
		System.out.println("Count of results is "+resCount);
		
		Assert.assertNotSame(0,lp.getresults().getText()); //Verifying the result count "3" in the text "...3 results" 
	
		
		}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	
  
	}
	
}
