package listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(testngTests2.MyListener.class)		//this line can be wriiten in case you do not wish to integrate both using xml file
public class ListenersTestOrangeHrm {

	WebDriver driver;
	
	  @BeforeClass
	  void openapp() {
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }
	  
	  @Test(priority = 1)
	  void testLogo() {
		  
		  boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		  Assert.assertEquals(status, true);
	  }
	  
	  @Test(priority = 2)
	  void testAppUrl() {
		  Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/");
	  }
	  
	  
	  @Test(priority=3, dependsOnMethods= {"testAppUrl"})
	  void ItestHomePageTitle() {
		  Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	  }
	  
	  @AfterClass
	  void teardown() {
		  driver.quit();
	  }
}

