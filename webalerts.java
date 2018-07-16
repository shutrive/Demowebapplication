package Demowebapplicationpackage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webalerts {

	WebDriver driver;
  	WebElement alerttab;
  	public static void main(String[] args) throws Exception {
  		webalerts d = new webalerts();
  		d.setup();
  		
  	}
  	
  	public void setup() throws Exception { 
  		System.setProperty("webdriver.gecko.driver", "C:\\Gecko Driver\\geckodriver.exe");
  		WebDriver driver = new FirefoxDriver();
  		driver.get("http://10.27.79.47:1411/");
  		// Print a Log In message to the screen
  		System.out.println("Successfully opened the Demo website");
  		alerttab = driver.findElement(By.xpath("//*[@id='A4']"));       
  		alerttab.click();
  		Thread.sleep(2000);
  		System.out.println("Successfully opened Alerts tab");
        // Verify simple alert and text
  		driver.findElement(By.xpath("//*[@id='body']/section/p[1]/button")).click();
  		 
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);
		simpleAlert.accept();
		
		//Verify confirm alert and text
		WebElement element = driver.findElement(By.xpath("//*[@id='body']/section/p[4]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
 
		Alert confirmationAlert = driver.switchTo().alert();
		String confirmalertText = confirmationAlert.getText();
		System.out.println("Alert text is " + confirmalertText);
		confirmationAlert.dismiss();
		
		//Switch by Index
		driver.switchTo().frame(0);
	
  	}

 	 public void tearDown() throws Exception { 
 		   driver.quit();
 		     } 
}
