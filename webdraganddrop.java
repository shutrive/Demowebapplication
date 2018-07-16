package Demowebapplicationpackage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Action;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class webdraganddrop {

	WebDriver driver;
	WebElement dragndroptab;
  	
  	public static void main(String[] args) throws Exception {
  		webdraganddrop d = new webdraganddrop();
  		d.setup();
}
  	
  	public void setup() throws Exception { 
  		System.setProperty("webdriver.gecko.driver", "C:\\Gecko Driver\\geckodriver.exe");
  		WebDriver driver = new FirefoxDriver();
  		driver.get("http://10.27.79.47:1411/");
  		// Print a Log In message to the screen
  		System.out.println("Successfully opened the Demo website");
  		dragndroptab = driver.findElement(By.xpath("//*[@id='menu']/li[4]/a"));       
  		dragndroptab.click();
  		Thread.sleep(2000);
  		driver.manage().window().maximize();
  		 
  		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
  		 
  		WebElement From = driver.findElement(By.xpath("//*[@id='item1']"));
  		 
  		WebElement To = driver.findElement(By.xpath("//*[@id='item4']"));
  		 
  		Actions builder = new Actions(driver);
  		 
  		Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
  		 
  		dragAndDrop.perform();
  		
  		System.out.println("Successfully dragged and dropped item 1 to item 4 position");	
  	}
}
