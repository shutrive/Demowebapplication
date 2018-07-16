package Demowebapplicationpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class webtable {
	WebDriver driver;
	WebElement webTable, element;
	String tablevalue;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		webtable d = new webtable();
  		d.setup();
	}
	
	public void setup() throws Exception { 
  		System.setProperty("webdriver.gecko.driver", "C:\\Gecko Driver\\geckodriver.exe");
  		WebDriver driver = new FirefoxDriver();
  		driver.get("http://10.27.79.47:1411/");
  		// Print a Log In message to the screen
  		System.out.println("Successfully opened the Demo website");
  		//web table tab
  		driver.findElement(By.xpath("//*[@id='A1']")).click();
  		System.out.println("Successfully opened webtable tab");
  		Thread.sleep(2000);
  	// print in console
  		for (int i= 1;i<=4;i++){
  			for (int j=1;j<=6;j++){
  					tablevalue = driver.findElement(By.xpath("//*[@id='body']/section/table/tbody/tr["+i+"]/td["+j+"]")).getText();
  					System.out.println(tablevalue);
  			}
  			
  		}
  		
  		//Get number of rows In table.
  		 int Rowcount = driver.findElements(By.xpath("//*[@id='body']/section/table/tbody/tr")).size();
  		 System.out.println("Number Of Rows = "+Rowcount);
  		 
  		 //Get number of columns In table.
  		 int Colcount = driver.findElements(By.xpath("//*[@id='body']/section/table/tbody/tr[1]/td")).size();
  		 System.out.println("Number Of Columns = "+Colcount);
  		 String s1 = "Dubai";
  		 String s2 = driver.findElement(By.xpath(".//*[@id='body']/section/table/tbody/tr[2]/td[3]")).getText();
  		 //Assert Dubai
  		if(s1.equals(s2))
  		System.out.println("Dubai found");
  		else
  		System.out.println("Dubai not found");	
	}
	


}

