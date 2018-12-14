package com.ibm.groceriespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PushNotificatoinPage {

	// Locating element for Add new link
	@FindBy(xpath = "//a[@title='Add New']")
	WebElement addnewEle;

	WebDriverWait wait;
	WebDriver driver;

	public PushNotificatoinPage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// TO click on Add new notification link
	public void clickonAddNotification() {

		addnewEle.click();
	}

}
