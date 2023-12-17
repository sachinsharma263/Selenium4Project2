package com.qa.pavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RelativeLocators {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://automationbookstore.dev/");
		driver.manage().window().maximize();

	}

	@Test(description = "Test book5 is left of book6 and below book2")
	public void test1() {
		WebElement book5=driver.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("pid6")).below(By.id("pid1")));
		String id=book5.getAttribute("id");
		System.out.println(id);
		Assert.assertEquals(id, "pid5");
	}
	@Test(description = "Test book2 is right of book1 and above book6")
	public void test2() {
		WebElement book2=driver.findElement(RelativeLocator.with(By.tagName("li")).toRightOf(By.id("pid1")).above(By.id("pid6")));
		String id=book2.getAttribute("id");
		System.out.println(id);
		Assert.assertEquals(id, "pid2");
	}
}
