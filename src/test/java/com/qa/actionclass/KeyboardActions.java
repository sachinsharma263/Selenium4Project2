package com.qa.actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");

		/*
		 * //sendKeys driver.findElement(By.name("q")).sendKeys("selenium"+Keys.ENTER);
		 */

		/*
		 * //keyDown driver.findElement(By.name("q")).sendKeys("selenium"+Keys.ENTER);
		 * Actions action=new Actions(driver);
		 * action.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
		 */

		WebElement searchBox = driver.findElement(By.name("q"));
		Actions action = new Actions(driver);

		action.keyDown(Keys.SHIFT).sendKeys(searchBox, "selenium").keyUp(Keys.SHIFT).sendKeys("selenium").build()
				.perform();

	}

}
