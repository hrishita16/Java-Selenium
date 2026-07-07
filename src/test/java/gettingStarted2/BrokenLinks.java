package gettingStarted2;

import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks {
	
	public static void handlingBrokenLinks() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		for(WebElement i : listOfLinks) {
			String hrefAttValue = i.getAttribute("href");
			if(hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("Empty!!..Not possible to check");
			}
			
			//hit url to the server
			try {
				URL linkUrl = new URL(hrefAttValue);
				HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();	//open the connection to server
				conn.connect();	//connect to server and send req
				
				if(conn.getResponseCode() >= 400) {
					System.out.println(hrefAttValue+"  --------->  "+"Broken link");
				}else {
					System.out.println(hrefAttValue+"  --------->  "+"Not a broken link");
				}
			}catch(Exception e) {
				
			}
			
		}
	}

}

       

/*
 1) Link
 2) https://xyz.com
 status code>=400 ------> broken link
 status code <400 ------> not a broken link
 */