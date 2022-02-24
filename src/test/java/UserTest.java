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
	  
	  //create

	  driver.get("http://localhost:8090/DEVOPSRR/UserServlet");

	  driver.findElement(By.linkText("Register")).click();
	  
//	  driver.findElement(By.name("name")).sendKeys("JohnDoe3");
//	  driver.findElement(By.name("password")).sendKeys("123");
//	  driver.findElement(By.name("email")).sendKeys("johndoe3@gmail.com");
	  
	  driver.findElement(By.name("name")).sendKeys("JohnDoe3");
	  driver.findElement(By.name("password")).sendKeys("123");
	  driver.findElement(By.name("email")).sendKeys("johndoe3@gmail.com");
	  
	  driver.findElement(By.id("submit_")).click();
	  
	  driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
	  
	  //update
	  driver.findElement(By.xpath("//a[@href='UserServlet/edit?name=JohnDoe3']")).click();
	  
	  
	  driver.findElement(By.name("name")).clear();
	  driver.findElement(By.name("name")).sendKeys("JohnDoe3Edited");
	  
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("1234");
	  
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("email")).sendKeys("johndoe3edited@gmail.com");

	  driver.findElement(By.id("submit_")).click();
	  
	  driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
	  
	  //delete
	  driver.findElement(By.xpath("//a[@href='UserServlet/delete?name=JohnDoe3']")).click();

	  
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
