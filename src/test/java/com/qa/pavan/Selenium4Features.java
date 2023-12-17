package com.qa.pavan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium4Features {

	WebDriver driver;
	By emailId = By.id("username");

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void openNewTab() throws InterruptedException {

		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("http://www.amazon.in");

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void openNewWindow() throws InterruptedException {

		driver.switchTo().newWindow(WindowType.WINDOW);

		driver.navigate().to("http://www.amazon.in");

		Thread.sleep(3000);

	}

	/*
	 * In Selenium 4, new getRect() method which returns a Rectangle object, and
	 * then you can directly get height, width and X/Y co-ordinates of element.
	 */
	@Test(priority = 3)
	public void location() {
		WebElement username = driver.findElement(emailId);
		System.out.println("Height of the web element: " + username.getRect().getHeight());
		System.out.println("Width of the we element: " + username.getRect().getWidth());

		System.out.println("X location: " + username.getRect().getX());
		System.out.println("Y location: " + username.getRect().getY());

		System.out.println("-----------------");

		Rectangle rect = username.getRect();
		System.out.println(rect.getHeight() + "\n" + rect.getWidth());
		System.out.println(rect.getX() + "\n" + rect.getY());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
