package loginAutomate;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.Architecture;

public class Login {
	
	WebDriver driver;
	
	@BeforeMethod
	public void loginLaunch() {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\abhis\\Downloads\\chromedriver.exe");
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-dev-shm-usage");
		// WebDriverManager.chromedriver().architecture(Architecture.X64).setup();
		// driver= new ChromeDriver(options);
		 String currentDir = System.getProperty("user.dir");
 		System.out.println("Current dir using System:" + currentDir);
		System.setProperty("webdriver.chrome.driver",currentDir +"\\chrome.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test 
	public void verifyTitle() {
		String actualTitle= driver.getTitle();
		String expectedTtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actualTitle, expectedTtitle);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
