package tryingOutEgs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo1 {
	public static void main(String[] args) throws InterruptedException{
		/*
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
//		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//		
//		Thread.sleep(5000);
		
//		driver.switchTo().alert().accept();
//		
//		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys("Welcome");
		driver.switchTo().alert().accept();
		
		
		*/
		
//		TableDemo2 obj = new TableDemo2();
//		obj.staticTableDemo();
		
//		PaginationPractice obj1 = new PaginationPractice();
//		obj1.paginationDemo();
		
		DatePickerPractice1.datePickerPractice1();
		
		
	}

}
