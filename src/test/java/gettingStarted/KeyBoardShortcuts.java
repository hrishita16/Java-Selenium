package gettingStarted;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardShortcuts {
	
	public static void keyBoardShortcutsDemo() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://text-compare.com/");
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome to selenium");
		Actions action = new Actions(driver);
		
		
		//Ctrl+A
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		
		//Ctrl+c
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//Ctrl+Tab
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//Ctrl+V
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
	}
	
	public static void keyBoardShortcutsDemo2() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement btnRegister =  driver.findElement(By.xpath("//a[@class='ico-register']"));
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(btnRegister).keyUp(Keys.CONTROL).perform();
		
		//action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).keyUp(Keys.CONTROL).perform();
		
		//switching to registration page
		List<String> ids = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1));
		
		//going back to home page
		driver.switchTo().window(ids.get(0));
		
	}

}
