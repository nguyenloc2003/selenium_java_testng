package selenium_java_testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_Browser_P1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Tương tác với Browser thì sẽ thông qua biến WebDriver driver
		//Tương tác với Element thì sẽ thông qua biến WebDriver element
		
	}

	@Test
	public void TC_01_Url() {
		driver.close();
	}

	@Test
	public void TC_02_Logo() {
		
	}

	@Test
	public void TC_03_Form() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
