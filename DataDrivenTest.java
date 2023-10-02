package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		
		Xls_Reader reader = new Xls_Reader("E:\\Selenium Java Programs\\eclipse\\MavenProject1\\src\\main\\java\\com\\testdata\\halfebaytestdata.xlsx");
		String firstname = reader.getCellData("RegiTestData", "firstname", 2);
		System.out.println(firstname);
		String lastname = reader.getCellData("RegiTestData", "lastname", 2);
		System.out.println(lastname);
		String email = reader.getCellData("RegiTestData", "email", 2);
		System.out.println(email);
		String password = reader.getCellData("RegiTestData", "password", 2);
		System.out.println(password);
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.half.ebay.com/");
		driver.findElement(By.xpath("//a[@href='https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F']")).click();
		
		
		driver.findElement(By.name("accountcreate")).click();
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("Email")).sendKeys(email);
		
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.name("EMAIL_REG_FORM_SUBMIT")).click();
	}

}
