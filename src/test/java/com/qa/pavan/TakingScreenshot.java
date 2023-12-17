package com.qa.pavan;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakingScreenshot {

	WebDriver driver;
	By emailId = By.id("username");
	By form = By.xpath("//form[@id='hs-login']");

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
	}

	@Test(description = "screenshot of an element")
	public void screenshotOfAnElement() {
		WebElement email = driver.findElement(emailId);
		highLightElement(driver,email);

		File src = email.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/screenshot1.png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(description = "screenshot of a section of page")
	public void screenshotOfSectionOfPage() {
		WebElement formElement = driver.findElement(form);
		File src = formElement.getScreenshotAs(OutputType.FILE);

		File dest = new File("./screenshot/screenshot2.png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(description = "screenshot of complete page")
	public void screenshotOfaPage() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshot/" + "screenshot3.png";
		File dest = new File(path);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void name() {
		driver.quit();
	}

	public void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].style.border='2px solid red'", element);
	}
}
