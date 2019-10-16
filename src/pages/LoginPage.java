package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*** locators 
	 */
/*	
	@FindBy(id = "email")
	private WebElement emailFieldLocator;
	
	@FindBy(id = "password")
	private WebElement passwordFieldLocator;
	
	@FindBy(name = "login")
	private WebElement LogInButtonLocator;
	
	@FindBy(id = "logo")
	private WebElement logoLocator;
	/*******************************
*/	 
	 /*** 
	  * web elements 
	  */
	
	public WebElement emailnputField = driver.findElement(By.id("email"));
	
	public WebElement passwordInputField = driver.findElement(By.id("password"));
	
	public WebElement loginButtonLocator = driver.findElement(By.name("login"));
	
	public WebElement logoButtonLocator = driver.findElement(By.id("logo"));

	 /*** 
	  * methods
	  */
	 	

	public LoginPage populateUsername(String username) {
		emailnputField.sendKeys(username);
		return this;
	}
	public LoginPage populatePassword(String password) {
		passwordInputField.sendKeys(password);
		return this;
	}
	
	public LoginPage clickLoginButton() {
		loginButtonLocator.click();
		return this;
	}
	
	public LoginPage waitForLogo() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
	return this;	
	}
	
	public LoginPage setFullScreen(WebDriver driver) {
		  driver.manage().window().maximize();
		  
	return this;
		}

}
