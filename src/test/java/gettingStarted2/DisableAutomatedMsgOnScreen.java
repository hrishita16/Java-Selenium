package gettingStarted2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMsgOnScreen {
	
	public static void disableMsgOnScreen() {
		
		/*
		 *whenever browser is launched, we see a msg saying that its been controlled by an automated software, which is selenium ofc 
		 *to remove or hide it, we do as follows
		 */
		
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver = new ChromeDriver(op);
		
		
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		String str = driver.getTitle();
		if(str.equals("OpenCart - Demo")) 
			System.out.println("Test passed");
		else 
			System.out.println("Test Failed");
	}

}
