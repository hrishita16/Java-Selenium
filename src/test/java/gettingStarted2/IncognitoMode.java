package gettingStarted2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode {
	
	public static void incognitoModeDemo() {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		
		
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		String str = driver.getTitle();
		if(str.equals("OpenCart - Demo")) 
			System.out.println("Test passed");
		else 
			System.out.println("Test Failed");
	}

}
