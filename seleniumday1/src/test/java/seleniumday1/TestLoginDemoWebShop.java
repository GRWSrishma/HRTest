package seleniumday1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLoginDemoWebShop {
	
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
	
		System.setProperty("webdriver.ie.driver", "C:\\Users\\training_b4c.06.01\\Documents\\selenium workspace\\Driver\\IEDriverServer.exe"); 
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\Documents\\selenium workspace\\Driver\\chromedriver.exe");
	     driver = new InternetExplorerDriver();
	   //driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	     driver.get("http://demowebshop.tricentis.com/");
	     
	}
	
	@AfterTest
	public void afterTest()
	{
		 driver.close();
	}
	
	@Test(dataProvider="dp1")
	public void testDemoWebShopLogin(String username,String password) {
		
	     driver.findElement(By.linkText("Log in")).click();
	     driver.findElement(By.id("Email")).sendKeys(username);
	     driver.findElement(By.id("Password")).sendKeys(password);
	     driver.findElement(By.cssSelector("input[value='Log in']")).click();
	     Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
		 driver.findElement(By.linkText("Log out")).click();
	     
	}

	@DataProvider(name="dp1")
	
	public Object[][] getData()
	{
		return TestReadExcel1.testReadExcel();
	}
}
