package com.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtility {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    static final By TITLE_TEXT= By.cssSelector("a[title='View my customer account'] span");

    public String getUserName()
    {
        return getDriver().findElement(TITLE_TEXT).getText();
    }


}
