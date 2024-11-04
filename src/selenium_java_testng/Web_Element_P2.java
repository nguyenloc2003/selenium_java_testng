package selenium_java_testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_Element_P2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	By emailTextbox = By.id("mail");
	By ageUnder18Radio = By.id("under_18");
	By educationTextArea = By.id("edu");
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By passwordTextbox = By.cssSelector("#disable_password");
	By biographyTextArea = By.cssSelector("#bio");
	By javaLanguagesCheckbox = By.cssSelector("#java");

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

	// @Test
	public void TC_01_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		// Textbox
		if (driver.findElement(emailTextbox).isDisplayed()) {
			driver.findElement(emailTextbox).sendKeys("Selenium Webdriver");
			System.out.println("email Textbox is displayed");
		} else {
			System.out.println("email Textbox is not displayed");
		}

		// Radio
		if (driver.findElement(ageUnder18Radio).isDisplayed()) {
			driver.findElement(ageUnder18Radio).click();
			System.out.println("age Under 18 radio is click");
		} else {
			System.out.println("age Under 18 radio is not click");
		}

		// TextArea
		if (driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("Selenium GRID");
			System.out.println("Education textarea is displayed");
		} else {
			System.out.println("Education textarea is not displayed");
		}

		if (driver.findElement(nameUser5Text).isDisplayed()) {
			System.out.println("nameUser5Text is displayed");
		} else {
			System.out.println("nameUser5Text is not displayed");
		}
	}

	// @Test
	public void TC_02_Enabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if (driver.findElement(passwordTextbox).isEnabled()) {
			System.out.println("password Textbox is enabled");
		} else {
			System.out.println("password Textbox is not enabled");
		}
		
		if (driver.findElement(biographyTextArea).isEnabled()) {
			System.out.println("biography TextArea is enabled");
		} else {
			System.out.println("biography TextArea is not enabled");
		}
		
		if (driver.findElement(emailTextbox).isEnabled()) {
			System.out.println("email Textbox is enabled");
		} else {
			System.out.println("email Textbox is not enabled");
		}
	}
	
	// @Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(javaLanguagesCheckbox).isSelected());
		
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(javaLanguagesCheckbox).click();
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(javaLanguagesCheckbox).isSelected());
		sleepInSecond(2);
		
		System.out.println("Age Under 18 radio button selected after click: " + (driver.findElement(ageUnder18Radio).isSelected() ? "Có: Element is selected" : "Không: Element is de-selected"));
	    System.out.println("Java Language checkbox selected after click: " + (driver.findElement(javaLanguagesCheckbox).isSelected() ? "Có: Element is selected" : "Không: Element is de-selected"));
		
		driver.findElement(By.id("java")).click();
		sleepInSecond(2);
		
		Assert.assertFalse(driver.findElement(javaLanguagesCheckbox).isSelected());
		System.out.println("Java Language checkbox selected after unchecking: " + (driver.findElement(javaLanguagesCheckbox).isSelected() ? "Có: Element is selected" : "Không: Element is de-selected"));
		
	}

	@Test 
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.id("email")).sendKeys("nguyenloc@gmail.com");
		
		By passwordTextbox = By.id("new_password");
		By signupButton = By.id("create-account-enabled");
		
		driver.findElement(passwordTextbox).sendKeys("abcd");
		driver.findElement(signupButton).click();
		sleepInSecond(2);
		
		// Verify lowercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("ABCD");
		driver.findElement(signupButton).click();
		sleepInSecond(2);
		
		// Verify uppercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("123456");
		driver.findElement(signupButton).click();
		sleepInSecond(2);
		
		// Verify number
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("!@#$");
		driver.findElement(signupButton).click();
		sleepInSecond(2);
		
		// Verify special char
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("abcd12345");
		driver.findElement(signupButton).click();
		sleepInSecond(2);
		
		// Verify char >= 8
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("abCD12@#");
		driver.findElement(signupButton).click();
		sleepInSecond(2);
		
		// Verify full data
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		

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

	}
}
