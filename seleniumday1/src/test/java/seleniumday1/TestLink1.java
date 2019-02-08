package seleniumday1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLink1 {
	
 @Test
public void Testlinks1() {

	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\Documents\\selenium workspace\\Driver\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
     driver.get("http://www.hdfcbank.com/");
     System.out.println("HDFC Banking Website is launched...");
     
     Actions Act1 = new Actions(driver);
     Act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']")));
     System.out.println("HDFC Banking Website is launched and hovered on Products...");
     Act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']")));
     Act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
     Act1.click(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
     Act1.perform();
     String url1 = driver.getCurrentUrl();
     Assert.assertTrue(url1.contains("credit_cards"));
     System.out.println("Credit Cards page is displayed...");
     
	 driver.close();
}
}
