package seleniumday1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCity1 {
	
	@Test(groups="actions1")
	
	public void testcities() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\Documents\\selenium workspace\\Driver\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	     
	     driver.get("https://www.cleartrip.com");
	     System.out.println("Clear Trip web site is launched...");
	     
	     WebElement From = driver.findElement(By.id("FromTag"));
	     
	     Actions Act1 = new Actions(driver);
	     Thread.sleep(5000);
	     Act1.sendKeys(From,"Hyd").perform();
	     Thread.sleep(8000);
	     Act1.sendKeys(Keys.ENTER).perform();
	     
	     String City = driver.findElement(By.id("From")).getAttribute("value");
	     Assert.assertEquals(City,"HYD");
	     
	     WebElement To = driver.findElement(By.id("ToTag"));
	     Act1.sendKeys(To,"Ban").perform();
	     
	     WebDriverWait wait = new WebDriverWait(driver,20);
	     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-2")));
	     WebElement ul = driver.findElement(By.id("ui-id-2"));
	     
	     List<WebElement> List = ul.findElements(By.tagName("li"));
	     Assert.assertEquals(10,List.size());
	     
	     for(WebElement li:List)
	     {
	    	 if(li.getText().contains("BKK"))
	    	 {
	    	     li.click();
	    		 break;
	    	 }
	     }
	         
	     driver.close();
	        
	}

}
