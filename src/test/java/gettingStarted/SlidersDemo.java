package gettingStarted;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SlidersDemo {
	
	public static void handlingSliderDemo() {
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement minSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		
		Point minLocation = minSlider.getLocation();
		System.out.println("Loc of min slider: "+minLocation);
		
		action.dragAndDropBy(minSlider, 100, 0).perform();
		System.out.println("Loc of min slider after dragging: "+minSlider.getLocation());
		
		
		
		WebElement maxSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
		Point maxLocation = maxSlider.getLocation();
		System.out.println("Loc of max slider: "+maxLocation);
		action.dragAndDropBy(maxSlider, -100, 0).perform();
		System.out.println("Loc of max slider after dragging: "+maxSlider.getLocation());
		
	}

}
