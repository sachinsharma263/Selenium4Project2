package com.qa.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * 
 * https://saucelabs.com/resources/blog/how-to-upgrade-to-selenium-4
 * from 3.8 se hi dc k kuch methods k jagah browser option class use karna suggest kiya selenium ne, se 4 me dc k kuch methods deprecated kar dye
 * dc class abhi bhi ha but kuch methods hata dye, dc kahi p use ho rahe but selenium ne dc class use karna discourged kar dya and recomened kya
 * ki browser options class use kk
 */
public class Demo {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("");
		dc.setPlatform(Platform.WIN10);
//		dc.setCapability("browserName", "chrome");

		ChromeOptions co = new ChromeOptions();
		co.setCapability("browserName", "chrome");
		co.setCapability("platformName", "Windows 10");
		
		FirefoxOptions fo = new FirefoxOptions();
		fo.setCapability("browserName", "firefox");
		fo.setCapability("platformName", "Windows 10");

		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.207.210:4444/"), fo);
		driver.manage().window().maximize();

		driver.get("http://app.hubspot.com/login");

		System.out.println(driver.getTitle());

		// driver=new ChromeDriver(dc);

	}

}
