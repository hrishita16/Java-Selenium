package gettingStarted2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {
	
	public static void headlessTestingDemo() {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String str = driver.getTitle();
		System.out.println(str);
		
		if(str.equals("OpenCart - Demo")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test Failed");
		}
		driver.quit();
	}

}
