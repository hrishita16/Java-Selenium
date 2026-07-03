package gettingStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethods {
	
	public void getMethodsPractise() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		System.out.println("window id: "+driver.getWindowHandle());
		
		if (driver.findElement(By.xpath("//span[contains(text(),'Forgotten password?')]")).isDisplayed()) {
			System.out.println("forgot password box found");
		}
		
		// similarly, isEnabled() and isSelected()
	}

}
	
