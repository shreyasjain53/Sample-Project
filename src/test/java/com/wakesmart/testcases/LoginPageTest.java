package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;

public class LoginPageTest extends BaseClass {
	public WebDriver driver;
	Action action = new Action();
	public IndexPage indexpage = new IndexPage(driver);

	@BeforeClass
	public void browserLaunch() throws IOException {
		try {
			driver = launchBrowser();
			driver.get(prop.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1, groups= {"Smoke,Sanity"})
	public void validUserLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);
		
		action.type(indexpage.getUserName(), prop.getProperty("UserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("Password"));
		action.click(driver, indexpage.getLogin());
		
		action.softAssertion(indexpage.geterrormsg(),  prop.getProperty("errorMessege"));
	}

}
