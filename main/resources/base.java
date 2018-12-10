package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("C:\\workspace\\Matrix\\Aconex\\main\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

//To execute in chrome driver
if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "C://workspace//Matrix//Learn//lib//chromedriver.exe");
	driver= new ChromeDriver();
		
	
}
else if (browserName.equals("firefox")) // To execute in firefox
{
	WebDriver driver;
	System.setProperty("webdriver.gecko.driver", "C://workspace//Matrix//Learn//lib//geckodriver.exe");
	driver =new FirefoxDriver();
	
}
else if (browserName.equals("IE"))
{
//	Currently requirement as per coding challenge is to run in only Firefox & Chrome
}

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
return driver;


}

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://workspace//Matrix//Aconex//screenshots"+result+"screenshot.png"));
	
}


}
