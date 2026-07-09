package DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");

		driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\calcdata.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for(int i=1; i<=rows; i++) {
			
			//read the data
			String principle = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String roi = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String period2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String exp_Mval = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//System.out.println(freq);
			
			//pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			
			WebElement drp1 = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select select1 = new Select(drp1);
			select1.selectByContainsVisibleText(period2);
			
			WebElement drp2 = driver.findElement(By.xpath("//select[@id='frequency']"));
			Select select2 = new Select(drp2);
			select2.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			String finalVal = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if(Double.parseDouble(finalVal) == Double.parseDouble(exp_Mval)) {
				
				System.out.println("Test passed..");
				ExcelUtils.setCellValue(filePath, "Sheet1", i, 7, "Test Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}else {
				System.out.println("Test failed..");
				ExcelUtils.setCellValue(filePath, "Sheet1", i, 7, "failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
		}
	}

}
