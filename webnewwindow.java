package Demowebapplicationpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;

public class webnewwindow {

	WebDriver driver;
	WebElement switchwindowtab;
  	
  	public static void main(String[] args) throws Exception {
  		webnewwindow d = new webnewwindow();
  		d.setup();
}
  	
  	public void setup() throws Exception { 
  		System.setProperty("webdriver.gecko.driver", "C:\\Gecko Driver\\geckodriver.exe");
  		WebDriver driver = new FirefoxDriver();
  		driver.get("http://10.27.79.47:1411/");
  		// Print a Log In message to the screen
  		System.out.println("Successfully opened the Demo website");
  		switchwindowtab = driver.findElement(By.xpath("//*[@id='A2']"));       
  		switchwindowtab.click();
  		Thread.sleep(2000);
  		driver.manage().window().maximize();
  		 
  		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
  		
  		
  		 driver.findElement(By.xpath("//*[@id='body']/section/p[1]/a")).click();

  		//Get all window handles and hold them in a list.
         Set<String> windowHandles = driver.getWindowHandles();
         List<String> windowHandlesList = new ArrayList<>(windowHandles); //Set to List Conversion
  
         //Write to total window handle number to the console.
         System.out.println("Total window number: " + windowHandlesList.size() + "\n");
  
         //Switch to second window
         driver.switchTo().window(windowHandlesList.get(1));
         System.out.println(driver.switchTo().window(windowHandlesList.get(1)).getTitle());
         System.out.println("I am on new window");
         System.out.println(driver.getTitle());
         
         driver.switchTo().defaultContent();
         System.out.println("I am on old window");
         System.out.println(driver.getTitle());
         
         driver.findElement(By.xpath("//*[@id='body']/section/p[2]/a")).click();
         List<String> tabs = new ArrayList<>(driver.getWindowHandles());
         System.out.println(tabs.size());
         driver.switchTo().window((String) tabs.get(0)); 
         System.out.println("I am on new tab");
         System.out.println(driver.getTitle());
         
         driver.close();
  		
  	}

 	 public void tearDown() throws Exception { 
 		   driver.quit();
 		     } 
}
