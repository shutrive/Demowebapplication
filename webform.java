package Demowebapplicationpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;

public class webform {
	
	  	WebDriver driver;
	  	WebElement webformtab, firstname, lastname, date, profession, continents;
	  	public static void main(String[] args) throws Exception {
	  		webform d = new webform();
	  		d.setup();
	  		
	  	}
	  	
	  	public void setup() throws Exception { 
	  		System.setProperty("webdriver.gecko.driver", "C:\\Gecko Driver\\geckodriver.exe");
	  		WebDriver driver = new FirefoxDriver();
	  		driver.get("http://10.27.79.47:1411/");
	  		// Print a Log In message to the screen
	  		System.out.println("Successfully opened the Demo website");
	  		webformtab = driver.findElement(By.xpath(".//*[@id='menu']/li[2]/a"));       
	  		webformtab.click();
	  		Thread.sleep(2000);
	  		
	  		firstname = driver.findElement(By.xpath("//*[@id='body']/section/hgroup/fieldset/div[5]/input"));       
	  		firstname.sendKeys("Shubhangi");
	  		lastname = driver.findElement(By.xpath("//*[@id='body']/section/hgroup/fieldset/div[8]/input"));       
	  		lastname.sendKeys("Trivedi");
	  		date = driver.findElement(By.xpath("//*[@id='body']/section/hgroup/fieldset/input"));       
	  		date.sendKeys("30112018");
	  		profession = driver.findElement(By.id("Checkbox2"));       
	  		profession.click();
	  		driver.findElement(By.id("tool-2")).click();
	  		Thread.sleep(2000);
	  		continents = driver.findElement(By.xpath("//*[@id='continents']"));
	  		Select oSelect = new Select(continents);
	  		oSelect.selectByVisibleText("Australia");
	  		//driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("‪C:\\IMG_20180204_054231466_BURST004.jpg");
	  		//driver.findElement(By.id("tool-2")).click(); 
	  		
	  		Thread.sleep(2000);
			driver.findElement(By.xpath("/*[@id='photo']")).sendKeys("‪C:\\\\IMG_20180204_054231466_BURST004.jpg");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("submit")).click();
	     } 
	  	
	  	
	  	 public void tearDown() throws Exception { 
	  		   driver.quit();
	  		     } 

	  }

