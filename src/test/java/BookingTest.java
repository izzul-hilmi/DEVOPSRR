import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BookingTest {
	
  @Test
  public void f() {
	// define the chrome driver
		  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		   // define the drive instance
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  // nagivate the browser to this url
		  driver.get("http://localhost:8090/DEVOPSRR/BookingServlet/dashboard");
		  // Navigate to this button to create the booking
		  driver.findElement(By.linkText("Add New Booking")).click();

		  driver.findElement(By.name("username")).sendKeys("testauto");
		  
		  driver.findElement(By.name("restaurant")).sendKeys("testauto");
		  
		  driver.findElement(By.name("time")).sendKeys("12:00 PM");
		  
		  driver.findElement(By.name("date")).sendKeys("23/02/2022");
		  
		  driver.findElement(By.id("createBooking")).click();
		  
		  //Edit the test auto booking 
		  driver.findElement(By.xpath("//a[@href='edit?username=testauto']")).click();
		  
		  driver.findElement(By.name("username")).clear();
		  
		  driver.findElement(By.name("username")).sendKeys("testauto2");
		  
		  driver.findElement(By.name("restaurant")).clear();
		  
		  driver.findElement(By.name("restaurant")).sendKeys("testauto2");
		  
		  driver.findElement(By.name("time")).clear();
		  
		  driver.findElement(By.name("time")).sendKeys("9:00PM");
		  
		  driver.findElement(By.name("date")).clear();
		  
		  driver.findElement(By.name("date")).sendKeys("23/02/2030");
		  
		  driver.findElement(By.id("save")).click();
		  
		  //Delete the test auto booking
		  driver.findElement(By.xpath("//a[@href='delete?username=testauto2']")).click();
		  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
