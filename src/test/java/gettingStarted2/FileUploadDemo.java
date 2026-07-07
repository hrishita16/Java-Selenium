package gettingStarted2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {
	
	public static void singleFileUpload() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\91996\\OneDrive\\Desktop\\sampleFilesForSeleniumUploadPractice\\test1.txt");
		
		if( driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("test1.txt") ) {
			System.out.println("Uploaded");
		}else
		{
			System.out.println("Failed to upload");
		}
	}
	
	
	
	public static void multipleFileUpload() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		String file1 = "C:\\Users\\91996\\OneDrive\\Desktop\\sampleFilesForSeleniumUploadPractice\\test1.txt";
		String file2 = "C:\\Users\\91996\\OneDrive\\Desktop\\sampleFilesForSeleniumUploadPractice\\test2.txt";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		int noOfFile = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		if(noOfFile == 2) {
			System.out.println("Uploaded");
		}else
		{
			System.out.println("Failed to upload");
		}
	}
	
}
