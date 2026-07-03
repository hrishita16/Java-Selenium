package tryingOutEgs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TableDemo2 {
	public void staticTableDemo() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://blazedemo.com/");
		WebElement departureCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select select = new Select(departureCity);
		
		select.selectByVisibleText("Paris");
		
		WebElement destinationCity = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select select1 = new Select(destinationCity);
		select1.selectByVisibleText("Rome");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		//System.out.println(rows);
		int cols = driver.findElements(By.xpath("//table[@class='table']//th")).size();
		
		
		
		int rowNum = 0;
		String firstPrice = driver.findElement(By.xpath("//table[@class='table']//tr[2]//td[6]")).getText().replace("$", "");
		double lowestPrice = Double.parseDouble(firstPrice);
		
		for(int i=2;i<rows-1;i++) {
			
			String price = driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText().replace("$", "");
			double currentPrice = Double.parseDouble(price);
			
			if(currentPrice < lowestPrice) {
				lowestPrice = currentPrice;
				rowNum = i;
				
			}
			
		}
		System.out.println("Lowest price found is: "+lowestPrice);
		System.out.println(rowNum);
		
		driver.findElement(By.xpath("//table[@class='table']//tr["+rowNum+"]//td[1]")).click();
		
		driver.findElement(By.name("inputName")).sendKeys("Manu Gupta");
		driver.findElement(By.id("address")).sendKeys("Noida");
		driver.findElement(By.id("city")).sendKeys("Noida");
		driver.findElement(By.id("state")).sendKeys("Uttar Pradesh");
		driver.findElement(By.id("zipCode")).sendKeys("12334");
		
		WebElement card = driver.findElement(By.xpath("//select[@id='cardType']"));
		Select select2 = new Select(card);
		select2.selectByVisibleText("American Express");
		
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("9");
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2025");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Manu Gupta");
		
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
		
		
		
		
	}

}
