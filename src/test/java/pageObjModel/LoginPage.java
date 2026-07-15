package pageObjModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By txtUsername_loc = By.xpath("//input[@placeholder='Username']");
	By txtPassword_loc = By.xpath("//input[@placeholder='Password']");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	public void setUsername(String username) {
		driver.findElement(txtUsername_loc).sendKeys("Admin");
	}
	
	public void setPassword(String password) {
		driver.findElement(txtPassword_loc).sendKeys("admin123");
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

}
