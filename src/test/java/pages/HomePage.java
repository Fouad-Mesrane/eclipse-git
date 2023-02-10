package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage {

	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button")
	WebElement loginBtn;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span")
	WebElement dashboardHeader;
	
	
	
	
	
	public void doLogin(String username, String password) {
		
		wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
		
	}
	
	public String headerTitle() {
		 waitForEleToBeVisible(dashboardHeader);
		 return dashboardHeader.getText();
		
		
	}
	
	
	
	
	
}
