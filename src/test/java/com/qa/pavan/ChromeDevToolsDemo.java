package com.qa.pavan;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v114.emulation.Emulation;
import org.openqa.selenium.devtools.v114.log.Log;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.security.Security;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevToolsDemo {

	WebDriver driver;

	@Test
	public void loadInsecureWebsite() {
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Security.setIgnoreCertificateErrors(true));

		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();

	}

	@Test(enabled = false)
	public void enableNetworkOffline() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		// Create Optional<Integer> objects with the desired values or leave them empty
		// if needed.
		Optional<Integer> maxTotalBufferSize = Optional.empty();
		Optional<Integer> maxResourceBufferSize = Optional.empty();
		Optional<Integer> maxPostDataSize = Optional.empty();

		// Call the Network.enable method with the correct argument types.
		devTools.send(Network.enable(maxTotalBufferSize, maxResourceBufferSize, maxPostDataSize));
		devTools.send(Emulation.canEmulate());

		driver.get("https://app.hubspot.com/login");
	}

	@Test(enabled = true)
	public void consoleLogs() {
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		devTools.createSession();
		// Create Optional<Integer> objects with the desired values or leave them empty
		// if needed.
		Optional<Integer> maxTotalBufferSize = Optional.empty();
		Optional<Integer> maxResourceBufferSize = Optional.empty();
		Optional<Integer> maxPostDataSize = Optional.empty();

		// Call the Network.enable method with the correct argument types.
		devTools.send(Network.enable(maxTotalBufferSize, maxResourceBufferSize, maxPostDataSize));
		devTools.send(Log.enable());
		devTools.addListener(Log.entryAdded(), entry -> System.out.println(entry.getText()));

		driver.get("https://app.hubspot.com/login");

		driver.findElement(By.id("username")).sendKeys("test");
	}
	
}
