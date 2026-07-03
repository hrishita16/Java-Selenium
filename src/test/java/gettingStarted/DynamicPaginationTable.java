package gettingStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {
	
	public void dynamicTableDemo() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.demoopencart.in/pos/oc3/admin/index.php?route=common/login");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse28']//a[contains(text(),'Customers')]")).click();
		
		String str = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		//System.out.println(str);
		String totalPages = str.substring(str.indexOf('(')+1 , str.indexOf("Pages")-1);
		//System.out.println(totalPages);
		
		int numOfPages = Integer.parseInt(totalPages);
		
		for(int i=1; i<=numOfPages; i++) {
			if(i>1) {
				WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+i+"]"));
				activePage.click();
			}
			
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			//System.out.println(rows);
			
			for(int r=1; r<=rows; r++) {
				String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				String IP = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[6]")).getText();
				
				System.out.println(customerName+"\t"+IP);
			}
		}
		
		
		
		
	}

}
