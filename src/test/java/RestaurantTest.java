import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class RestaurantTest {
  @Test
  public void f() {
	// define the chrome driver
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");

       // define the drive instance
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      // nagivate the browser to this url
      driver.get("http://localhost:8090/DEVOPSRR/RestaurantServlet/dashboard");
      // Navigate to this button to create the booking
      driver.findElement(By.linkText("Add New Restaurant")).click();

      driver.findElement(By.name("name")).sendKeys("testauto");

      driver.findElement(By.name("hotline")).sendKeys("123");

      driver.findElement(By.name("address")).sendKeys("testsauto");
      
      driver.findElement(By.id("createRestaurant")).click();

      //Edit the test auto booking 
      driver.findElement(By.xpath("//a[@href='delete?name=testauto']")).click();

  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
