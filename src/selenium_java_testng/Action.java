package selenium_java_testng;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Action {
	WebDriver driver;
	Actions action;
	JavascriptExecutor jsExecutor;
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
		action = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	// @Test
	public void Tooltip() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		
		action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
	}
	
	// @Test
	public void Fahasa() {
		driver.get("https://www.fahasa.com/");
		sleepInSecond(8);
		
		action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
		sleepInSecond(2); 
		
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Sách Trong Nước']//span[@class='menu-title']"))).perform();
		sleepInSecond(3);
		
		driver.findElement((By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']"))).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//strong[text()='Kỹ năng sống']")).isDisplayed());
	}
	
	// @Test
	public void Click_And_Hold_Block() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List<WebElement> listNumber =  driver.findElements(By.cssSelector("ol#selectable>li"));
		
		action.clickAndHold(listNumber.get(0)).moveToElement(listNumber.get(15)).release().perform();
		
		sleepInSecond(3);
		
		List<WebElement> listSelectedNumber = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		Assert.assertEquals(listSelectedNumber.size(), 16);
		
	}
	
	@Test
	public void Click_And_Hold_Random() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		Keys key = null;
		
		if (osName.contains("Windows")) {
			key = Keys.CONTROL;
		} else {
			key = Keys.COMMAND;
		}
		
		List<WebElement> listNumber =  driver.findElements(By.cssSelector("ol#selectable>li"));
		
		action.keyDown(key).perform();
		
		action.click(listNumber.get(0)).click(listNumber.get(4)).click(listNumber.get(7)).click(listNumber.get(11)).perform();
		
		action.keyUp(key).perform();
		
		List<WebElement> listSelectedNumber = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		Assert.assertEquals(listSelectedNumber.size(), 4);
	}
	
	@Test
	public void Double_Click() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//button[text()='Double click me']")));
		sleepInSecond(3);
		
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
		
	}
	
	@Test
	public void Right_Click() {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
		
		driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed();
		
		action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-hover")).isDisplayed());
		
		action.click(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
		sleepInSecond(3);
		
		driver.switchTo().alert().accept();
		sleepInSecond(3);
		
		Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
		
	}
	
	@Test
	public void Drag_And_Drop_HTML4() {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		
		WebElement smallCircle = driver.findElement(By.cssSelector("div#draggable"));
		WebElement bigCircle = driver.findElement(By.cssSelector("div#droptarget"));
		
		action.dragAndDrop(smallCircle, bigCircle).perform();
		
		Assert.assertEquals(bigCircle.getText(), "You did great!");
		
		String bigCircleRGB = bigCircle.getCssValue("background-color");
		
		String bigCircleHexa = Color.fromString(bigCircleRGB).asHex();
		
		bigCircleHexa = bigCircleHexa.toUpperCase();
		
		Assert.assertEquals(bigCircleHexa, "#03A9F4");
		
	}
	
	public void sleepInSecond(long timeInSecond) {
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
