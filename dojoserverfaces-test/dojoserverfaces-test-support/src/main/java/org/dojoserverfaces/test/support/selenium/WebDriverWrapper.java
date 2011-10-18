package org.dojoserverfaces.test.support.selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverWrapper implements WebDriver {

	private String serverHost;
	private int serverPort;
	private String contextRoot;
	private WebDriver driver;
	
	public WebDriverWrapper(WebDriver driver, String serverHost, int serverPort, String contextRoot) {
		this.serverHost = serverHost;
		this.serverPort = serverPort;
		this.contextRoot = contextRoot;
		this.driver = driver;
	}
	
	@Override
	public void get(String url) {
		
		System.out.println("URL = http://" + serverHost + ":" + serverPort + "/" + contextRoot + "/" + url);
		driver.get("http://" + serverHost + ":" + serverPort + contextRoot + "/" + url);

	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public void close() {
		driver.close();
		
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}


}
