package gettingStarted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new ChromeDriver();
		
//		driver.get("https://demoblaze.com/");
		
		/*
		 * List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		 * System.out.println("Total links: "+listOfLinks.size());
		 * 
		 * List<WebElement> listOfImgs = driver.findElements(By.tagName("img"));
		 * System.out.println("total imgs: "+listOfImgs.size());
		 * 
		 * driver.findElement(By.linkText("Samsung Galaxy s6")).click();
		 * driver.findElement(By.partialLinkText("galaxy")).click();
		 */
		
		
		/*
		 * driver.navigate().to("https://www.opencart.com/"); if( driver.findElement(By.
		 * xpath("//ul[@class='nav navbar-nav']//a[normalize-space()='Features']")).
		 * isDisplayed() ) { System.out.println("Features button found"); }
		 */
		
//		DriverMethods obj = new DriverMethods();
//		obj.getMethodsPractise();
		
//		NavigateDemo obj2 = new NavigateDemo();
//		obj2.navigateDemo();
		
//		HandleBrowserWindow obj3 = new HandleBrowserWindow();
//		obj3.handlingBrowserWindowDemo();
		
//		CheckBoxesDemo obj4 = new CheckBoxesDemo();
//		obj4.checkBoxesDemo();
		
//		HandleAlerts obj5 = new HandleAlerts();
//		obj5.handlingAlertDemo();
		
//		HandleFrames obj6 = new HandleFrames();
//		obj6.handlingFrame();
		
//		SelectDropdown obj7 = new SelectDropdown();
//		obj7.selectDropdown();
		
//		AutoSuggestDropdown obj8 = new AutoSuggestDropdown();
//		obj8.autoSuggestDropdown();
		
//		StaticWebTable obj9 = new StaticWebTable();
//		obj9.staticWebTableDemo();
		
//		DynamicPaginationTable obj10 = new DynamicPaginationTable();
//		obj10.dynamicTableDemo();
		
//		DatePickerDemo obj11 = new DatePickerDemo();
//		obj11.datePickerDemo();
		
		MouseActions obj12 = new MouseActions();
		//obj12.mouseHoverDemo();
		//obj12.clickActionDemo();
		obj12.dragDropDemo();
		
		
		
		//driver.close() 	//if two windows are open, it'll close the first window
		//driver.quit() 	//it closes all the windows
	}

}
