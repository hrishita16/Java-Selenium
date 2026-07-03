package gettingStarted;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleBrowserWindow {

	public void handlingBrowserWindowDemo() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * WebElement link = wait.until( ExpectedConditions.elementToBeClickable(
		 * By.xpath("//a[normalize-space()='OrangeHRM, Inc']") ) );
		 * 
		 * link.click();;
		 * 
		 * Set<String> windowIDs = driver.getWindowHandles(); List<String> windowList =
		 * new ArrayList(windowIDs);
		 * 
		 * String parentID = windowList.get(0); String childID = windowList.get(1);
		 * 
		 * System.out.println(driver.getTitle()); //even though another window is opened
		 * on clicking, driver is still at the first window
		 * driver.switchTo().window(childID); //now we switched to the second window
		 * System.out.println(driver.getTitle()); //this will now print the second
		 * window title
		 * 
		 * 
		 * driver.switchTo().window(parentID); System.out.println(driver.getTitle());
		 * 
		 * 
		 * //approach 2 
		 * for(String windID : windowIDs) { 
		 * String title =
		 * driver.switchTo().window(windID).getTitle(); 
		 * if(title.equals("OrangeHRM")) {
		 * 	System.out.println(driver.getCurrentUrl()); 
		 * } 
		 * }
		 */
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//*[@id=\"wikipedia-search-result-link\"]/a")));
		
		List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-results\"]"));
		System.out.println("Number of search result links: "+links.size());
		
		
		List<String> listOfUrl = new ArrayList<>();
		for(WebElement element : links) {
		    String href = element.getAttribute("href");
		    System.out.println("href = " + href);

		    if(href != null) {
		        listOfUrl.add(href);
		    }
		}
		
		for(String url : listOfUrl) {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(url);
		}
		
		
		Set<String> windowIds = driver.getWindowHandles();
		List<String> listOfWindow = new ArrayList<>(windowIds);
		
		for(String id : windowIds) {
			System.out.println(id);
		}
		
		for(String id : windowIds) {
			driver.switchTo().window(id);
			if(driver.getTitle().contains("Selenium dioxide")) {
				driver.close();
			}
		}
	}
}
