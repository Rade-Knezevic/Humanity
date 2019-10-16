package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

protected WebDriver driver = null;
	
protected BasePage(WebDriver driver) {
    this.driver = driver;
    
	}



/** methods
 */

public BasePage setFullScreen(WebDriver driver) {
	  driver.manage().window().maximize();
	  
return this;
	}
}

