package gettingStarted2;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingScreenshotDemo {
	
	public static void fullPageScreenshotDemo() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);		//capturing the ss as type file. png, etc can also be captured
		
		//C:\D\AllLearnings\screenshots
		File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		
		sourceFile.renameTo(targetFile);
	}
	
	public static void specificSectionScreenshotDemo() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='application/view/image/demonstration/store-admin.png']"));
		File sourceFile = ele.getScreenshotAs(OutputType.FILE);
		File targertFile = new File(System.getProperty("user.dir")+"\\screenshots\\administrationImg.png");
		sourceFile.renameTo(targertFile);
	}

}
