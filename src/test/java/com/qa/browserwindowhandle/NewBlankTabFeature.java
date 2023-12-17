package com.qa.browserwindowhandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewBlankTabFeature {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");

		System.out.println(driver.getTitle());

		driver.switchTo().newWindow(WindowType.TAB);

		System.out.println("title:" + driver.getTitle());

		Thread.sleep(3000);

		Set<String> handles = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(handles);

		String parentWindow = list.get(0);
		String childWindow = list.get(1);

		System.out.println(parentWindow + "\n" + childWindow);

		driver.close();

		driver.switchTo().window(parentWindow);

		System.out.println(driver.getTitle());

	}
}
