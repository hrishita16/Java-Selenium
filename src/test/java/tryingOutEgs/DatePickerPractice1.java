package tryingOutEgs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerPractice1 {
	public static void datePickerPractice1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		
		String date1 = "1";
		
		WebElement dpYear = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select select1Select = new Select(dpYear);
		select1Select.selectByVisibleText("2027");
		
		WebElement dpMonth =  driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select select = new Select(dpMonth);
		select.selectByVisibleText("Feb");
		
		List<WebElement> list1= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for(WebElement i : list1) {
			if(i.getText().equals(date1)) {
				i.click();
				break;
			}
		}
		
	}

}
