package gettingStarted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
	
	public void selectDropdown() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement drpCountry = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select selectObj = new Select(drpCountry);
		
		selectObj.selectByVisibleText("France");
		selectObj.selectByValue("japan");
		selectObj.selectByIndex(2);
		
		//capturing all options from the dropdown
		List<WebElement> options = selectObj.getOptions(); 	//this method returns all the options in the dropdown
		System.out.println("number of options in dropdown "+options.size());
		
		for(WebElement i : options) {
			System.out.println(i.getText());
		}
		
	}

}
