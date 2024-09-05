package loginAutomate;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.config.Architecture;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {
	
	WebDriver driver;
	
	@BeforeMethod
	public void loginLaunch() {
//		 ChromeOptions options = new ChromeOptions();
//		 options.addArguments("--no-sandbox");
//		 options.addArguments("--disable-dev-shm-usage");
//		 WebDriverManager.chromedriver().architecture(Architecture.X64).setup();
//		 driver= new ChromeDriver(options);
		String currentDir = System.getProperty("user.dir");
 		System.out.println("Current dir using System:" + currentDir);
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		//options = new ChromeOptions();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-debugging-port=9222");
		options.addArguments("--headless"); // Run in headless mode
	        options.addArguments("--no-sandbox"); // Bypass the sandbox
	        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
		driver = new ChromeDriver(options);
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test 
	public void verifyTitle() {
		String actualTitle= driver.getTitle();
		String expectedTtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println("Page Title is "+ driver.getTitle());
		Assert.assertEquals(actualTitle, expectedTtitle);
	}
	
	@AfterMethod
	public void tearDown() {
		 if (driver != null) {
		driver.quit();
		 }
	}

}
