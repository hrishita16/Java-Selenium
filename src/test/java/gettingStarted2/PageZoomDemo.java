package gettingStarted2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageZoomDemo {
	
	public static void pageZoomInOutDemo() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en/demo");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		
		js.executeScript("document.body.style.zoom='80%'");
	}

}
