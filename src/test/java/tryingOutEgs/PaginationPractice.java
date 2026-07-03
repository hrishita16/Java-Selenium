package tryingOutEgs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationPractice {
	
	public void paginationDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		for(int i=1; i<=4; i++) {
			
			driver.findElement(By.xpath("//a[normalize-space()="+i+"]")).click();
			
			int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			for(int r=1; r<=rows; r++) {
				String name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
				String price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]")).getText();
				
				driver.findElement(By.xpath("//tbody/tr["+r+"]/td[4]/input[1]")).click();
				
				System.out.println(name+"\t"+price);
			}
		}
	}

}