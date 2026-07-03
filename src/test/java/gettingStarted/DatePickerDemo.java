package gettingStarted;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	
	public void datePickerDemo() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://jqueryui.com/datepicker/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("datepicker")).click();
		
		DatePickerDemo obj = new DatePickerDemo();
		//obj.selectFutureDate(driver, "September", "2026", "7");
		obj.selectPastDate(driver, "September", "2025", "7");
	
	}
	
	
	public void selectFutureDate(WebDriver driver, String month, String year, String day ) {
		
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(month.equalsIgnoreCase(currentMonth) && year.equalsIgnoreCase(currentYear)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		
		int rows = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr")).size();
		int cols = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//th")).size();
		
		for(int i=1; i<=rows; i++) {
			for(int j=1;j<=cols; j++) {
				String val = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr["+i+"]//td["+j+"]")).getText();
				if(val.equals(day)) {
					driver.findElement(By.xpath("//a[normalize-space()="+val+"]")).click();
					break;
				}
			}
		}
	}
	
public void selectPastDate(WebDriver driver, String month, String year, String day ) {
		
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(month.equalsIgnoreCase(currentMonth) && year.equalsIgnoreCase(currentYear)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
		}
		
		
		// we can also write the same for loop as below
		List<WebElement> listOfDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for(WebElement dt : listOfDates) {
			if(dt.getText().equals(day)) {
				dt.click();
			}
		}
	}

}
