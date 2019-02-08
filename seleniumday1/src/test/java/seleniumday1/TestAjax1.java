package seleniumday1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAjax1 {

	@Test(groups= {"actions1","actions2"})
	public void testAjaxFeature()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\Documents\\selenium workspace\\Driver\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	     driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	     System.out.println("Webpage is loaded....");

	     WebElement From = driver.findElement(By.xpath("//div[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
	     
	     WebElement To = driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
	     
	     Actions Act1 = new Actions(driver);
	     Act1.clickAndHold(From).release(To);
	     Act1.perform();
	     
	     WebDriverWait wait = new WebDriverWait(driver,30);
	     
	     wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"),"Drop a package here to check price" ));
	     
	     String result = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
	     
	     System.out.println("The result displayed is ..." + result);
	     
	     Assert.assertTrue(result.contains("$3999"));
	     
	     driver.close();
	}
}
