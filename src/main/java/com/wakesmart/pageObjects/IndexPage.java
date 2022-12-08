package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class IndexPage extends BaseClass {

	By UserName = By.xpath("//input[@id='email']");
	By PassWord = By.xpath("//input[@id='pass']");
	By Login = By.xpath("(//button[normalize-space()='Log in'])[1]");
	By errormsg = By.xpath("(//div[@class='_9ay7'])[1]");

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(Login);
	}

	public WebElement getUserName() {
		return driver.findElement(UserName);
	}

	public WebElement getPassWord() {
		return driver.findElement(PassWord);

	}
	
	public String geterrormsg() {
		return driver.findElement(errormsg).getText();

	}
}