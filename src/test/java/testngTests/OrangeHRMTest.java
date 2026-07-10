package testngTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	WebDriver driver;
	
  @Test(priority = 1)
  void openapp() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  
  @Test(priority = 2)
  void testLogo() {
	  
	  boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	  System.out.println("logo displayed status: "+status);
  }
  
  @Test(priority = 3)
  void testLogin() {
	  
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
  }
  
  @Test(priority = 4)
  void closeapp() {
	  driver.quit();
  }
}