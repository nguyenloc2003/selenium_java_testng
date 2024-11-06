package selenium_java_testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Button_Radio_Checkbox {
	WebDriver driver;
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Default_Checkbox_Radio_Single() {
		driver.get("https://automationfc.github.io/multiple-fields/");

		driver.findElement(By.xpath("//label[contains(text(), 'Hepatitis')]/preceding-sibling::input")).click();

		driver.findElement(By.xpath("//label[contains(text(),'1-2 cups/day')]/preceding-sibling::input")).click();

		Assert.assertTrue(driver
				.findElement(By.xpath("//label[contains(text(), 'Hepatitis')]/preceding-sibling::input")).isSelected());
		Assert.assertTrue(
				driver.findElement(By.xpath("//label[contains(text(),'1-2 cups/day')]/preceding-sibling::input"))
						.isSelected());

		driver.findElement(By.xpath("//label[contains(text(), 'Hepatitis')]/preceding-sibling::input")).click();

		Assert.assertFalse(driver
				.findElement(By.xpath("//label[contains(text(), 'Hepatitis')]/preceding-sibling::input")).isSelected());

		driver.findElement(By.xpath("//label[contains(text(), 'Hepatitis')]/preceding-sibling::input")).click();

		Assert.assertTrue(driver
				.findElement(By.xpath("//label[contains(text(), 'Hepatitis')]/preceding-sibling::input")).isSelected());

	}

	@Test
	public void Default_Checkbox_Multiple() {
		driver.get("https://automationfc.github.io/multiple-fields/");

		List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("input.form-checkbox"));

		for (WebElement checkbox : allCheckboxes) {
			checkbox.click();
		}

		for (WebElement checkbox : allCheckboxes) {
			Assert.assertTrue(checkbox.isSelected());
		}

		for (WebElement checkbox : allCheckboxes) {
			if (checkbox.getAttribute("value").equals("Asthma")) {
				checkbox.click();
			}
		}

	}

	@Test
	public void Default_Checkbox() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		
		if (!driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).click();
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).isSelected());
		
		if (driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).click();
		}
		
		Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).isSelected());
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
//		driver.quit();
	}
}
