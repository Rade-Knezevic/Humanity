package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.TimeClockPage;
import utils.Constants;

public class clockInClockOutOnOverviewPage {
	
	
  @Test
  public void testClockInClockOutOnOverviewPage() {
	  
	  System.setProperty(Constants.CHROME_DRIVER_PROPERTY, Constants.CHROME_DRIVER_LOCATION);  
	  
	  String sManagerEmail = "rade.testing@gmail.com";
	  String sManagerPassword = "Test1Hum";

	  WebDriver driver = new ChromeDriver();
	  
	  driver.get(Constants.BASIC_URL);
	  
	  LoginPage loginPage = new LoginPage(driver);
	  
	  loginPage.setFullScreen(driver)
	  	.waitForLogo()
	  	.populateUsername(sManagerEmail)
	  	.populatePassword(sManagerPassword)
	  	.clickLoginButton();
	  
	  MainPage mainPage = new MainPage(driver);
	  
	  mainPage.waitForDashboardLink();
	  
	  TimeClockPage timeClockPage = new TimeClockPage(driver);
			  
	  timeClockPage.clickOnTimeClockButton()
	  	.waitForGreenTimeClockButton()
	  	.clickGreenClockedInButton()
	  	.waitForStatusMessage();
	  
	  boolean userClockedIn = timeClockPage.isUserClockedIn();
	  
	  assert userClockedIn == true:"User didn't clock in successfully";
	  
	  timeClockPage.waitForRedTimeClockButton()
	    .waitForStatusMessageToDiminish()	
	    .clickRedClockedInButton()
	  	.waitForStatusMessage();
	  
	  boolean userClockedOut = timeClockPage.isUserClockedOut();
	  
	  assert userClockedOut == true:"User didn't clock out successfully";
	  
	  driver.quit();
	  
  }
}
