package com.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {

    public HomePage(String browserName) {
        super(browserName);
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage(String browserName,boolean isHeadless) {
        super(browserName,isHeadless);
    }

    static final By LOGIN_LINK=By.cssSelector("a.login");

    public LoginPage selectLogin()
    {
        clickOn(LOGIN_LINK);
        return new LoginPage(getDriver());
    }

}
