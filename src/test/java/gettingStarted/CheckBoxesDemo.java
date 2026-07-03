package gettingStarted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesDemo {
	
	public void checkBoxesDemo() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//selecting all checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		//selecting all checkboxes							
		for(int i=0; i<checkboxes.size(); i++) {				 
			checkboxes.get(i).click();							  
		}
		
		
		//same way of writing above for loop
		for(WebElement i : checkboxes) {
			i.click();
		}
		
		//selecting last 3 checkboxes
		/*
		 * first count total no of checkboxes, here it is 7, so (7-3) = 4, the starting
		 * inxed will be 4
		 */
		
		
		for(int i=4; i<checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		
		//unselecting the checkboxes which are already selected
		for(int i=0;i<checkboxes.size(); i++) {
			if(checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
		}
		
	}

}
