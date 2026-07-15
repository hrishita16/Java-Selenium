package pageObjModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUsingPageFactory {
	
	WebDriver driver;
	
	public LoginPageUsingPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement txtUsername;
	
	@FindBy(how = How.XPATH,  using = "//input[@placeholder='Password']")	//this is another way to write the same thing
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(tagName = "a")		//just an eg to capture multiple web elements
	List<WebElement> links;
	
	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}

}