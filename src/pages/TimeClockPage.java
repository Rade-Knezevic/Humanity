package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeClockPage extends BasePage{

	public TimeClockPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String idOfStatusDiv = "_status";
	
	private String xpathOfStatusDivClockedIn = "//div[text()='Clocked in.']";
	
	private String xpathOfStatusDivClockedOut = "//div[text()='Clocked out.']";
	
	private String idOfTimeClockButtonGreen = "tc_tl_ci";
	
	private String idOfTimeClockButtonRed = "tc_tl_co";
			
	private String idOfTimeClockButton = "sn_timeclock";
	
	private WebElement timeClockButton = driver.findElement(By.id(idOfTimeClockButton));

	 
	public TimeClockPage clickOnTimeClockButton() {
		timeClockButton.click();
		return this;
	}
	
	public TimeClockPage waitForGreenTimeClockButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idOfTimeClockButtonGreen)));
	return this;	
	}
	
	public TimeClockPage waitForRedTimeClockButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idOfTimeClockButtonRed)));
	return this;	
	}

	
	public TimeClockPage clickGreenClockedInButton() {
		WebElement timeClockButtonGreen = driver.findElement(By.id(idOfTimeClockButtonGreen));

		timeClockButtonGreen.click();
		return this;
	}
	
	public TimeClockPage clickRedClockedInButton() {
		WebElement timeClockButtonRed = driver.findElement(By.id(idOfTimeClockButtonRed));
		timeClockButtonRed.click();
		return this;
	}
	
	public TimeClockPage waitForStatusMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idOfStatusDiv)));
	return this;	
	}
	
public TimeClockPage waitForStatusMessageToDiminish() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(idOfStatusDiv)));
	return this;	
	}
	
	/*public String getClockedInMessageText() {
		String clockedInText = driver.findElement(By.id(idOfStatusDiv)).getText();
		System.out.println(clockedInText);
		return clockedInText;
	}*/
	
	public Boolean isUserClockedIn() {
		boolean isExists = true;
		try {
		driver.findElement(By.xpath(xpathOfStatusDivClockedIn));
		}catch (NoSuchElementException e) {
	        isExists = false;
	    }
		return isExists;
	}
	
	public Boolean isUserClockedOut() {
		boolean isExists = true;
		try {
		driver.findElement(By.xpath(xpathOfStatusDivClockedOut));
		}catch (NoSuchElementException e) {
	        isExists = false;
	    }
		return isExists;
	}

}
