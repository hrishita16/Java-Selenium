package gettingStarted;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitsDemo {
	
	WebDriver driver = new ChromeDriver();
	public WaitsDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	public void implicitWaitDemo() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		/*
		 * this will wait for by default zero seconds to max 5 seconds, depending upon how much a particular part needs 
		 * it will be applicable to the entire program unlike the sleep function
		 */
		
		driver.get("https://www.facebook.com/");
		driver.get("https://www.youtube.com/");
	}
	
	public void explicitWaitDemo() throws InterruptedException {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement txtUserName = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@placeholder='Username']")));
		txtUserName.sendKeys("admin");
		
		WebElement txtPassword = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		txtPassword.sendKeys("password");
		
		WebElement loginBtn = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		loginBtn.click();
		
	}
	
	
	
	public void fluentWaitDemo() {
		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		WebElement txtUserName = myWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@placeholder='Username']"));
			}
		});
		
		txtUserName.sendKeys("admin");
	}
	

}
