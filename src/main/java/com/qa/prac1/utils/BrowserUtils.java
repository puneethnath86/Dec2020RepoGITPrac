package com.qa.prac1.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author punath
 *	This is a browser Util class that holds all the methods used to perform browser actions
 *	Methods include
 *	1. Launch BROWSER
 *	2. Launch URL
 *	
 *	
 *	
 */

/**
 * @author punath
 *
 */
/**
 * @author punath
 *
 */
public class BrowserUtils 
{
	public WebDriver driver;
	
	
	/**
	 * @param browserName
	 * @return driver
	 * This method is used to launch browser with the passed browser name
	 */
	public WebDriver launchBrowser(String browserName) 
	{
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Please pass valid browser name");
		}		
		return driver;
	}
	
	
	/**
	 * @param browserName
	 * @return driver
	 * This method is used to launch the browser in headless mode
	 */
	public WebDriver launchHeadLessBrowser(String browserName) {
		
		System.out.println("This is method for launching browser in HEADLESS mode");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Launching chrome browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver(co);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo=new FirefoxOptions();
			fo.addArguments("--headless");
			driver=new FirefoxDriver(fo);
		}
		else {
			System.out.println("Please pass valid browser name");
		}
		return driver;
	}
	
	/**
	 * @param browserName
	 * @return driver
	 * This method is used to launch the browser in INCOGNITO mode
	 */
	public WebDriver launchIncognitoBrowser(String browserName) {
		System.out.println("This is method for launching browser in incognito mode");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Launching chrome browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--incognito");
			driver=new ChromeDriver(co);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo=new FirefoxOptions();
			fo.addArguments("--incognito");
			driver=new FirefoxDriver(fo);
		}
		else {
			System.out.println("Please pass valid browser name");
		}
		return driver;
	}
	
	/**
	 * @param browserName
	 * @return driver
	 * This method is used to launch the browser after ignoring certificate errors
	 */
	public WebDriver launchBrowserIgnoreCertificateErrors(String browserName) {
		
		System.out.println("This is method for launching browser in HEADLESS mode");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--ignore-certificate-errors");
			driver=new ChromeDriver(co);
		}
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo=new FirefoxOptions();
			fo.addArguments("--ignore-certificate-errors");
			driver=new FirefoxDriver(fo);
		}
		else {
			System.out.println("Please pass valid browser name");
		}
		return driver;
	}
	
	
	/**
	 * @param url 
	 * This method is used to launch the URL
	 */
	public void launchURL(String url) {
		driver.get(url);
	}
	
	
	/**
	 * @return pageTitle as String
	 * This is used to get title of the current page
	 */
	public String getPageTitle() {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		return driver.getTitle();
	}
	
	/**
	 * @return page URL
	 * This method is used to get the current page URL
	 */
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}
