package gettingStarted2;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionAtRuntime {
	
	public static void enableExtensions() {
		
		ChromeOptions op = new ChromeOptions();
		
		File file = new File("C:\\Users\\91996\\Downloads\\SelectorsHub-Chrome-Web-Store.crx");
		op.addExtensions(file);
		
		
		WebDriver driver = new ChromeDriver(op);
		
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		driver.get("https://text-compare.com/");
		
		driver.get("chrome://extensions/");
	}

}

/*
 * Enable extensions in browser
 * 
 * step 1: Add CRX Extractor/Downloader to chrome Browser ( manually) Step2 :
 * Add SelectorsHub plugin to chrome browser (manually) step3 : Capture crx file
 * for selectorshub extension Step4: pass crx file path in automation script in
 * Chrome Options
 */
