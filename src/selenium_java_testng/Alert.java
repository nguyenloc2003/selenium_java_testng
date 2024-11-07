package selenium_java_testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Alert {
	WebDriver driver;
	WebDriverWait explicitWait;
	org.openqa.selenium.Alert alert;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("MAC OS")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}

		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSceond(3);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		sleepInSceond(3);
		
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		
		alert.accept();
		sleepInSceond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
		
	}
	
	@Test
	public void Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSceond(3);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		sleepInSceond(3);
		
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		
		alert.dismiss();
		sleepInSceond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
		
	}
	
	@Test
	public void Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSceond(3);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		sleepInSceond(3);
		
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		
		String courseName = "Automation Testing";
		
		alert.sendKeys(courseName);
		sleepInSceond(3);
		
		alert.accept();
		sleepInSceond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + courseName);
	}
	
	@Test
	public void Authentication_Alert() {
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.get(passUserAndPassToUrl("http://the-internet.herokuapp.com/basic_auth", "admin", "admin"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		
	}
	
	public String passUserAndPassToUrl(String url, String username, String password) {
		String[] arrayUrl = url.split("//");
		return arrayUrl[0] + "//" + username + ":" + password + "@" + arrayUrl[1];
	}
	public void sleepInSceond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
