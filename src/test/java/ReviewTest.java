import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ReviewTest {
  @Test
  public void f() {
	  
	// define the chrome driver
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");

	   // define the drive instance
	  WebDriver driver = new ChromeDriver();
	  // nagivate the browser to this url
	  driver.get("http://localhost:8090/DEVOPSRR/CommentServlet/dashboard");
	  // browser look for link with text value "Why RP?"
	  driver.findElement(By.linkText("Add New Review")).click();
	  
	  driver.findElement(By.name("name")).sendKeys("Testname");
	  
	  driver.findElement(By.name("review")).sendKeys("Testreview");

	   // browser look for link with text value "Experience Real-World Learning"
	  driver.findElement(By.id("comment")).click();
	  
	  driver.findElement(By.xpath("//a[@href='edit?name=Testname']")).click();
	  
	  driver.findElement(By.name("name")).clear();
	  
	  driver.findElement(By.name("review")).clear();
	  
	  driver.findElement(By.name("name")).sendKeys("Testnamereeee");
	  
	  driver.findElement(By.name("review")).sendKeys("Testreviewreeee");
	  
	  driver.findElement(By.id("editC")).click();
	  
	  driver.findElement(By.xpath("//a[@href='delete?name=Testnamereeee']")).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
