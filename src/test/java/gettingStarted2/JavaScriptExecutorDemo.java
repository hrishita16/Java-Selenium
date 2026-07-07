package gettingStarted2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
	
	public static void javaScriptExecutorDemo() {
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://testautomationpractice.blogspot.com/");
		//driver.findElement(By.id("name")).sendKeys("Manu Gupta");
		
		WebElement nameBox = driver.findElement(By.id("name"));
		
		//same thing we can do using js executor
		JavascriptExecutor js = (JavascriptExecutor)driver;		//type casting as WebDriver & JavascriptExecutor are different types
		
		/*
		 * here type casting is not req, RemoteWebDriver implements JavascriptExecutor
		 * and hence if we create ChromeWebDriver obj we can directly write it
		 * ChromeWebDriver extends RemoteWebDriver and so it will also inherit
		 * JavascriptExecutor methods
		 */
		//JavascriptExecutor js = driver;	
		
		js.executeScript("arguments[0].setAttribute('value', 'John')", nameBox);
		
		/*-----------note--------
		JavascriptExecutor can be used when we get element intercepted error
		else the other methods can be used as usual
		*/
		
		
		WebElement radioBtn = driver.findElement(By.id("male"));
		js.executeScript("arguments[0].click()", radioBtn);
	}

}
