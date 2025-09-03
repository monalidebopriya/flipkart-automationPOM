package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.config.Config;
import com.qa.utils.DriverFactory;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage()
	{
		this.driver=DriverFactory.getDriver();
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(Config.TIMEOUT));
		
	}
    public String getPageTitle() {
	    return driver.getTitle();
	  }

	public String getPageSource() {
	   return driver.getPageSource();
	  }
}
