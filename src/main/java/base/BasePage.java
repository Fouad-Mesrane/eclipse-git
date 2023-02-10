package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.Config;
import utils.TimeUnits;

public class BasePage {

	
	public static Properties prop = Config.loadProps();
	
	protected static String screenshotName;
	
	public static WebDriver driver;
	 public static JavascriptExecutor jsDriver;
	public static WebDriverWait wait;
	// launching the browser
	
	
	@BeforeMethod
	public void initBrowser() {
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(TimeUnits.EXPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUnits.PAGE_LOAD));
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
			
	}
	
	
	
	// Selenium Util Methods
	
	public boolean isVisible(WebElement element) {
		try {
		 element = wait.until(ExpectedConditions.visibilityOf(element));
		
		}catch (Exception e){
			return false;
		}
		return true ;
	}
	
	 public void waitForEleToBeVisible(WebElement element){
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	
	
	 public String jsGetElementText(WebElement element) {
	        jsDriver = (JavascriptExecutor) (driver);
	        String query = "arguments[0].text";

	        return jsDriver.executeScript(query, element).toString();
	    }
	
	
 public static void captureScreenshot() {
		 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		 
		 Date d = new Date();
		 screenshotName = d.toString().replace(":", "_").replace(" ", "_")+ ".jpg";
		 try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
