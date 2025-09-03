
package com.qa.pages;

import com.qa.config.Config;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;

	public class FlipkartHomePage extends BasePage {

	    private By body = By.tagName("body");
	    private By searchBox = By.name("q");

	    public FlipkartHomePage() {
	        super();
	    }

	    public void open() {
	        driver.get(Config.BASE_URL);
	    }

	    public void closeLoginPopup() {
	        driver.findElement(body).sendKeys(Keys.ESCAPE);
	    }

	    public void searchProduct(String product) {
	        WebElement search = driver.findElement(searchBox);
	        search.sendKeys(product);
	        search.sendKeys(Keys.ENTER);
	    }

	    public boolean verifyResults(String keyword) {
	        return getPageSource().contains(keyword);
	    }
	}


