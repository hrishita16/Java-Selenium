package gettingStarted;

import java.lang.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
	
	public void handlingAlertDemo() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		// -------------ALERT WITH OK BUTTON --------------------
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		
		
//		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//		Thread.sleep(5000);
		
		//driver.switchTo().alert().accept();		//directly we can switch to the alert and accept it
		
//		Alert myAlert = driver.switchTo().alert();
//		System.out.println(myAlert.getText()); 		// this will capture the text on the alert
//		myAlert.accept();
		
		
		
		
		// ----------------ALERT WITH OK & CANCEL BUTTON--------------
//		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
//		Thread.sleep(5000);
		
//		driver.switchTo().alert().accept();		//accepts alert by clicking ok button
//		driver.switchTo().alert().dismiss(); 	//closes alert by clicking on cancel button
		
		
		
		
		// -------ALERT WITH PROMPT -------------
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(5000);
		
		Alert myPromptAlert = driver.switchTo().alert();
		myPromptAlert.sendKeys("Welcome");
		myPromptAlert.accept();
		
		
		
	}

}
