package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class HalfEbayTest {

	WebDriver driver;

	 @BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath("//a[@contains(class,'nI-gNb-lg-rg__login')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
				.sendKeys("madhavi.patil1234@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Maddyshiv@2505");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		// driver.findElement(By.name("accountcreate")).click();

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void halfEbayRegPageTest(String firstname, String lastname, String Email, String password) {

		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(firstname);

		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lastname);

		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(Email);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
