package gettingStarted2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageScrollingDemo {
	
	public static void pageScrollingByPixel() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.nopcommerce.com/en/demo");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//scrolling down by pixel number
		js.executeScript("window.scrollBy(0,1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
	}
	
	public static void pageScrollingTillSpecificElement() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.nopcommerce.com/en/demo");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement ele = driver.findElement(By.xpath("//h2[normalize-space()='The Perfect Solution!']"));
		//scrolling till a specific page element
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
	}
	
	public static void pageScrollingTillEnd() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.nopcommerce.com/en/demo");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(5000);
		
		//scrolling all the way up again
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		
	}

}
