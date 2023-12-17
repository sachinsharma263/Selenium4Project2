package com.qa.actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");

		WebElement boxA = driver.findElement(By.name("A"));
		WebElement boxD = driver.findElement(By.name("D"));

		Actions action = new Actions(driver);
//		action.moveToElement(boxA);
//		
//		action.clickAndHold(boxA);
//		action.moveToElement(boxD).build().perform();

		//action.moveToElement(boxA).clickAndHold().moveToElement(boxD).build().perform();
		//action.moveToElement(boxA).clickAndHold().moveToElement(boxD).release().build().perform();
		
		//action.contextClick(boxA).perform();
		
		driver.navigate().to("https://selenium08.blogspot.com/2020/01/drag-drop.html");
		
		WebElement element1=driver.findElement(By.id("draggable"));
		WebElement element2=driver.findElement(By.id("droppable"));
		
		
		action.dragAndDrop(element1, element2).perform();
	}

}
