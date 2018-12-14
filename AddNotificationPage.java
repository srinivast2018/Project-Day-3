package com.ibm.groceriespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNotificationPage {

	// Locating element for Notification name field
	@FindBy(xpath = "//input[@name='name']")
	WebElement nameEle;

	// Locating element for Message field
	@FindBy(xpath = "//textarea[@name='message']")
	WebElement messageEle;

	// Locating element for image
	@FindBy(xpath = "//input[@id='files']")
	WebElement imageEle;

	// Locating element for Save button
	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveEle;

	WebDriverWait wait;
	WebDriver driver;

	public AddNotificationPage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	//To add push notification
	public String addNotification(String notification, String message,String imagepath) {
		nameEle.sendKeys(notification);
		messageEle.sendKeys(message);
		//imageEle.sendKeys("C:\\Users\\IBM_ADMIN\\eclipse-workspace\\TestCases_DataDrivenFramework\\TestData\\globe.jpg");
		imageEle.sendKeys(imagepath);
		saveEle.click();
		return driver.getPageSource();
	}

}
