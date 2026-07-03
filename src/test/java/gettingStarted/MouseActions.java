package gettingStarted;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	public void mouseHoverDemo() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://vinothqaacademy.com/mouse-event/");
		
		WebElement btnAboutMe = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse pull-right']//a[contains(text(),'About Me')]"));
		WebElement btnInside = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse pull-right']//a[normalize-space()='LinkedIn Profile']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(btnAboutMe).moveToElement(btnInside).click().build().perform();
	}
	
	
	public void clickActionDemo() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://vinothqaacademy.com/mouse-event/");
		Actions action = new Actions(driver);
		
		WebElement btnDoubleClick = driver.findElement(By.xpath("//button[@id='doubleBtn']"));
		action.doubleClick(btnDoubleClick).perform();
		
		WebElement btnRightClick = driver.findElement(By.xpath("//button[@id='rightBtn']"));
		WebElement btnInside2 = driver.findElement(By.xpath("//button[normalize-space()='Copy']"));
		action.contextClick(btnRightClick).moveToElement(btnInside2).click().build().perform();
	}
	
	public void dragDropDemo() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://vinothqaacademy.com/mouse-event/");
		Actions action = new Actions(driver);
		
		WebElement drag = driver.findElement(By.xpath("//div[@id='dragItem']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='dropZone']"));
		
		Action myAction = action.dragAndDrop(drag, drop).build();	//just build and store this action, later you can perform it
		myAction.perform();		//as and when needed we can perform this already build action
	}

}
