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
	  
	  var name = driver.findElement(By.name("name"));
	  var password = driver.findElement(By.name("password"));
	  var email = driver.findElement(By.name("email"));
	  var submit = driver.findElement(By.id("submit_"));
	  
//	  driver.findElement(By.name("name")).sendKeys("JohnDoe3");
//	  driver.findElement(By.name("password")).sendKeys("123");
//	  driver.findElement(By.name("email")).sendKeys("johndoe3@gmail.com");
	  
	  name.sendKeys("JohnDoe3");
	  password.sendKeys("123");
	  email.sendKeys("johndoe3@gmail.com");
	  
	  submit.click();
	  
	  driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
	  
	  //update
	  driver.findElement(By.xpath("//a[@href='UserServlet/edit?name=JohnDoe3']")).click();
	  
	  var name2 = driver.findElement(By.name("name"));
	  var password2 = driver.findElement(By.name("password"));
	  var email2 = driver.findElement(By.name("email"));
	  var submit2 = driver.findElement(By.id("submit_"));
	  
	  name2.clear();
	  name2.sendKeys("JohnDoe3Edited");
	  
	  password2.clear();
	  password2.sendKeys("1234");
	  
	  email2.clear();
	  email2.sendKeys("johndoe3edited@gmail.com");

	  submit2.click();
	  
	  driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
	  
	  //delete
	  driver.findElement(By.xpath("//a[@href='UserServlet/delete?name=JohnDoe3']")).click();
	  
	  driver.quit();
	  
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
