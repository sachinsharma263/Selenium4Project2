package com.qa.actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {

	public static void main(String[] args) {

		By login = By.id("Login");
		By travelAgent = By.id("TravelAgentLoginText");
		By subAgent = By.id("SubAgentLoginText");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://book.spicejet.com/LoginAgent.aspx");

		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(login)).moveToElement(driver.findElement(travelAgent))
//				.click(driver.findElement(subAgent)).build().perform();

//		WebElement loginELement=driver.findElement(login);
//		action.moveToElement(loginELement).perform();
//		
//		WebElement travelAgentELement=driver.findElement(travelAgent);
//		action.moveToElement(travelAgentELement).perform();
//		
//		WebElement subAgentELement=driver.findElement(subAgent);
//		action.click(subAgentELement).perform();

		doMoveToElement(driver, login);
		doMoveToElement(driver, travelAgent);
		doActionClick(driver, subAgent);

	}

	public static void doMoveToElement(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public static void doActionClick(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(driver, locator)).perform();
	}

	public static WebElement getElement(WebDriver driver, By locator) {
		return driver.findElement(locator);
	}
}
