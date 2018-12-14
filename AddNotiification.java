package com.ibm.groceries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.groceriespages.PageLogin;
import com.ibm.groceriespages.AddNotificationPage;
import com.ibm.groceriespages.PageDashboard;
import com.ibm.groceriespages.PageProducts;
import com.ibm.groceriespages.PushNotificatoinPage;
import com.ibm.initialization.WebDriverLaunch;
import com.ibm.utilities.PropertiesFileHandler;
import jdk.nashorn.internal.runtime.PrototypeObject;

public class AddNotiification extends WebDriverLaunch {
	
//To add new push notification
	@Test(priority = 1, testName = "AddNotification", groups = "low")
	public void addPushNotificatoin() {
	
		//Getting the values defined in properties file
		String url = data.get("url");
		String userName = data.get("username");
		String password = data.get("password");
		String expMessage = data.get("expNotificationMessage");
		String notificaitonName = data.get("notifyName").toString();
		String notificatoinMessage = data.get("notifyMessage").toString();
		String imagePath=data.get("imagePath");
		
		// Launching the web site for atozgroceries
		driver.get(url);

		PageLogin login = new PageLogin(driver, wait);
		// To enter email address and password and click on login button
		login.enterEmailAddress(userName);
		login.enterPassword(password);
		login.clickOnLogin();
		Assert.assertTrue(driver.findElement(By.partialLinkText("Logout")).isDisplayed());

		PageDashboard dashboard = new PageDashboard(driver, wait);
		dashboard.clickOnMarketing();
		dashboard.clickOnPushNotification();

		PushNotificatoinPage notification = new PushNotificatoinPage(driver, wait);
		// calling method to click on add notification button
		notification.clickonAddNotification();

		AddNotificationPage add = new AddNotificationPage(driver, wait);
		String pageSource = add.addNotification(notificaitonName, notificatoinMessage,imagePath);

		// Verifying whether the expected message displayed after adding notification

		if (pageSource.contains(expMessage))
			System.out.println(expMessage);
		Assert.assertTrue(pageSource.contains(expMessage), "Assertion on Adding Notificaiton");

		//Verifying the notification name and notification message added
		if (pageSource.contains(notificaitonName))
			System.out.println(notificaitonName);
		Assert.assertTrue(pageSource.contains(notificaitonName), "Assertion on added notification name");

		if (pageSource.contains(notificaitonName))
			System.out.println(notificatoinMessage);
		Assert.assertTrue(pageSource.contains(notificatoinMessage), "Assertion on added notification message");

	}

}
