import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UserTest {
  @Test
  public void f() {
	  

	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");

	  WebDriver driver = new ChromeDriver();

	  driver.get("http://localhost:8090/DEVOPSRR/UserServlet");

	  driver.findElement(By.linkText("Register")).click();
	  
	  driver.findElement(By.name("yourName")).sendKeys("JohnDoe3");
	  driver.findElement(By.name("yourPassword")).sendKeys("123");
	  driver.findElement(By.name("yourEmail")).sendKeys("johndoe3@gmail.com");
	  
	  driver.findElement(By.id("submit_")).click();
	  
	  driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
	  
//	  driver.findElement(By.xpath("//linkText")).click();
	  
//	  driver.navigate().refresh();  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
