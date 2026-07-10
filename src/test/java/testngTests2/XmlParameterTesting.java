package testngTests2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class XmlParameterTesting {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	void setup(String br, String url) throws InterruptedException {
		
		switch(br.toLowerCase()) {
		case "chrome": 
			driver = new ChromeDriver(); 
			break;
		
		case "edge": 
			driver = new EdgeDriver(); 
			break;
			
		case "firefox": 
			driver = new FirefoxDriver(); 
			break;
			
		default: 
			System.out.println("Invalid browser"); 
			return;		//this will break the entire loop and remaining statements outside switch will not get executed
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		Thread.sleep(3000);
		
	}

	@Test(priority = 1)
	void testLogo() {
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
		
	}
	
	@Test(priority = 2)
	void testTitle(){
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		
	}
	
	@Test(priority = 3)
	void testUrl() {
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
	}
	

	@AfterClass
	void tearDown(){
		driver.quit();
	}
}

/*
parallel testing using xml file

step1) 		created test case
step2) 		create xml file then run test case through xml
step3) 		passed browser name, url as parameters from xml file to setup() method
step4) 		execute test case on chrome, firefox & Edge (serial execution)
step5) 		execute test case on chrome, firefox & edge ( parallel execution)
*/