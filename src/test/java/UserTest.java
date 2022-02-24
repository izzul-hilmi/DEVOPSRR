import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UserTest {
  @Test
  public void f() {
	  
	// define the chrome driver
      System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");

       // define the drive instance
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      // nagivate the browser to this url
      driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
      // Navigate to this button to create the booking
      driver.findElement(By.linkText("Register")).click();

      driver.findElement(By.name("name")).sendKeys("John123");
      driver.findElement(By.name("password")).sendKeys("123");
      driver.findElement(By.name("email")).sendKeys("john123@gmail.com");
      
      driver.findElement(By.id("submit_")).click();
      
      //Edit the test auto booking 
      driver.findElement(By.xpath("//a[@href='UserServlet/edit?username=John123']")).click();
      
      driver.findElement(By.name("name")).clear();
      
      driver.findElement(By.name("name")).sendKeys("John123Edit");
      
      driver.findElement(By.name("email")).clear();
      
      driver.findElement(By.name("email")).sendKeys("john123edit@gmail.com");
      
      driver.findElement(By.id("submit_")).click();
      
      //Delete the test auto booking
      driver.findElement(By.xpath("//a[@href='UserServlet/delete?username=John123Edit']")).click();
      

  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
