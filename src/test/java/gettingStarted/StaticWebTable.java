package gettingStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {
	
	public void staticWebTableDemo() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("No of rows "+rows);
		
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("No of cols "+cols);
		
		//read data from a specific row
		String txt1 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]//td[3]")).getText();
		System.out.println(txt1);
		
		//read all data from rows and cols
//		for(int i=2; i<=rows; i++) {
//			for(int j=1; j<cols; j++) {
//				System.out.println("Row "+i+" col "+j+" value = "+driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText());
//			}
//		}
		
		
		
		
		//print books written by mukesh
		for(int i=2; i<=rows; i++) {
			String val = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			if(val.equalsIgnoreCase("mukesh")) {
				String book = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
				System.out.println("book found: "+book);
			}
		}
		
		
		
		int sum = 0;
		//capture price of all and find sum
		for(int i=2; i<=rows; i++) {
			String val = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			int numVal = Integer.parseInt(val);
			sum += numVal;
		}
		System.out.println("Total price: "+sum);
		
		
	}

}
