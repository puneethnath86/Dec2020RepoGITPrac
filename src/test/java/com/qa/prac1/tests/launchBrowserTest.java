package com.qa.prac1.tests;

import org.testng.annotations.Test;

import com.qa.prac1.utils.BrowserUtils;

public class launchBrowserTest 

{
	@Test
	public void openBrowser() {
		BrowserUtils br=new BrowserUtils();
		br.launchIncognitoBrowser("chrome");
		br.launchURL("https://www.yahoo.com");
		System.out.println("Title of the page is--> "+br.getPageTitle());
		System.out.println("URL of the page is--> "+br.getPageURL());
		br.quitBrowser();
	}
}
