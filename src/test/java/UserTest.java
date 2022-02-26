import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UserTest {
	
	
	@Test(priority=1)
	public void register() {

		// define the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");

		// define the drive instance
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		
		// nagivate the browser to this url
		driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
		// Navigate to this button to create the booking
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.name("yourName")).sendKeys("John1234");
		driver.findElement(By.name("yourPassword")).sendKeys("123");
		driver.findElement(By.name("yourEmail")).sendKeys("john123@gmail.com");

		driver.findElement(By.id("submit_")).click();
		
		driver.quit();
		
	}
	
	@Test(priority=2)
	public void edit() {
		
		// define the chrome driver
				System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");

				// define the drive instance
				WebDriver driver = new ChromeDriver();
//				driver.manage().window().maximize();

		driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
		// Edit the test auto booking
		driver.findElement(By.xpath("//a[@href='UserServlet/edit?name=John1234']")).click();

		driver.findElement(By.name("name")).clear();

		driver.findElement(By.name("name")).sendKeys("John1234Edit");
		
//		driver.findElement(By.name("password")).sendKeys("123");

		driver.findElement(By.name("email")).clear();

		driver.findElement(By.name("email")).sendKeys("john123edit@gmail.com");

		driver.findElement(By.id("edit")).click();

		driver.quit();
	}
	
	@Test(priority=3)
	public void delete() {
		// define the chrome driver
				System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");

				// define the drive instance
				WebDriver driver = new ChromeDriver();
//				driver.manage().window().maximize();
				
		driver.get("http://localhost:8090/DEVOPSRR/UserServlet");

		// Delete the test auto booking
		driver.findElement(By.xpath("//a[@href='UserServlet/delete?name=John1234Edit']")).click();

		driver.quit();
	}

//	@Test
//	public void functinB() {
//
//		// define the chrome driver
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
//
//		// define the drive instance
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		// nagivate the browser to this url
//		driver.get("http://localhost:8090/DEVOPSRR/UserServlet");
//		// Navigate to this button to create the booking
//		driver.findElement(By.linkText("Register")).click();
//
//		driver.findElement(By.id("submit_")).click();
//	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
