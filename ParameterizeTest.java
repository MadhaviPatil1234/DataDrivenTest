package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		
		//launching browser
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.half.ebay.com/");
		driver.findElement(By.xpath("//a[@href='https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F']")).click();
		driver.findElement(By.name("accountcreate")).click();
		
		Xls_Reader reader = new Xls_Reader("E:\\Selenium Java Programs\\eclipse\\MavenProject1\\src\\main\\java\\com\\testdata\\halfebaytestdata.xlsx");
	    
		reader.addColumn("RegiTestData", "Status");
		int rowcount = reader.getRowCount("RegiTestData");
		for(int rowno=2; rowno<=rowcount; rowno++) {
			System.out.println("*****************************************");
			String firstname = reader.getCellData("RegiTestData", "firstname", rowno);
			System.out.println(firstname);
			String lastname = reader.getCellData("RegiTestData", "lastname", rowno);
			System.out.println(lastname);
			String email = reader.getCellData("RegiTestData", "email", rowno);
			System.out.println(email);
			String password = reader.getCellData("RegiTestData", "password", rowno);
			System.out.println(password);
			
			
							
			driver.findElement(By.id("firstname")).clear();
			driver.findElement(By.id("firstname")).sendKeys(firstname);
			
			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.id("lastname")).sendKeys(lastname);
			
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Email")).sendKeys(email);
			
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(password);
			
			reader.setCellData("RegiTestData", "Status", rowno, "Pass");
			}

	}

}
