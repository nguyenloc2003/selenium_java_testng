// Chạy trên hệ điều hành Windows

package selenium_java_testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Run_On_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@Test
	public void TC_01_Run_Chrome() {
		//Chrome
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();
	}
	@Test
	public void TC_02_Run_FireFox() {
		//FireFox
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();
	}
	@Test
	public void TC_03_Run_Edge() {
		//Edge
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();
	}
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}





//Chạy trên hệ điều hành MAC

//package selenium_java_testng;
//
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class Topic_04_Run_On_Browser {
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	String osName = System.getProperty("os.name");
//	
//	@BeforeClass
//	public void beforeClass() {
//		
//	}
//	
//	@Test
//	public void TC_01_Run_Chrome() {
//		//Chrome
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		}
//		else {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//		}
//		
//		driver = new ChromeDriver();
//		driver.get("https://demo.nopcommerce.com/");
//		driver.quit();
//	}
//	@Test
//	public void TC_02_Run_FireFox() {
//		//FireFox
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		}
//		else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		}
//		
//		driver = new FirefoxDriver();
//		driver.get("https://demo.nopcommerce.com/");
//		driver.quit();
//	}
//	@Test
//	public void TC_03_Run_Edge() {
//		//Edge
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//		}
//		else {
//			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
//		}
//		driver = new EdgeDriver();
//		driver.get("https://demo.nopcommerce.com/");
//		driver.quit();
//	}
//	@AfterClass
//	public void afterClass() {
//		// driver.quit();
//	}
//}
