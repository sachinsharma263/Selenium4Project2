package com.qa.selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowser {

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		// co.setHeadless(true);

		WebDriver driver = new ChromeDriver(co);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
	}

}
