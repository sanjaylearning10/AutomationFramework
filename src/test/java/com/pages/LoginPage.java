package com.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    static final By EMAIL_LOCATOR= By.cssSelector("input#email");
    static final By PASSWORD_LOCATOR= By.cssSelector("input#passwd");
    static final  By SIGN_IN_LOCATOR= By.cssSelector("button#SubmitLogin");

    public MyAccountPage doLogin(String email,String password){
        enterText(EMAIL_LOCATOR,email);
        enterText(PASSWORD_LOCATOR,password);
        clickOn(SIGN_IN_LOCATOR);
        return new MyAccountPage(getDriver());
    }
}
