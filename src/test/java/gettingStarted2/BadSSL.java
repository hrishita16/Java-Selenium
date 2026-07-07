package gettingStarted2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BadSSL {
	
	public static void badSslDemo() {
		
		ChromeOptions op = new ChromeOptions();
		op.setAcceptInsecureCerts(true);	//this will accept the SSL certificates
		
		WebDriver driver = new ChromeDriver(op);
		
		driver.get("https://expired.badssl.com/");
		System.out.println("Page title is: "+driver.getTitle());
	}

}
