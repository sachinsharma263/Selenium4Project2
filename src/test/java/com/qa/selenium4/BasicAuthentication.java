package com.qa.selenium4;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Headers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication {

	private static String username="admin";
	private static String password="admin";
	
	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		
		DevTools devTools=((ChromiumDriver)driver).getDevTools();
		devTools.createSession();
		
		// Create Optional<Integer> objects with the desired values or leave them empty if needed.
		Optional<Integer> maxTotalBufferSize = Optional.empty();
		Optional<Integer> maxResourceBufferSize = Optional.empty();
		Optional<Integer> maxPostDataSize = Optional.empty();
		
		// Call the Network.enable method with the correct argument types.
		devTools.send(Network.enable(maxTotalBufferSize, maxResourceBufferSize, maxPostDataSize));
		
		Map<String, Object> headers=new HashMap<String,Object>();
		String basiAuth="Basic "+new String(new Base64().encode(String.format("%s:%s", username,password).getBytes()));
		
		headers.put("Authorization", basiAuth);
		
		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
	}

}
