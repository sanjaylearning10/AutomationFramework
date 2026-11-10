package com.test;

import com.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtlity;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
  protected  HomePage homePage;
  private boolean isLamdaTest;

    @Parameters({"browser","isLamdaTest","isHeadless"})
    @BeforeMethod(description = "Load the home page")
    public void setUp(ITestResult result,  @Optional("chrome") String browser, @Optional("true") boolean isLamdaTest, @Optional("true") boolean isHeadless)
    {
        WebDriver remoteWebDriver;
        this.isLamdaTest=isLamdaTest;
        if(isLamdaTest)
        {
            remoteWebDriver= LamdaTestUtlity.initializeLambdaTestSession(browser,result.getMethod().getMethodName());
        homePage=new HomePage(remoteWebDriver);
        }
        else {
       // homePage=new HomePage("chrome");
        homePage=new HomePage("chrome",isHeadless);
     }
    }

    public BrowserUtility getInstance(){
        return homePage;
    }

    @AfterMethod
    public void tearDown() {
        if(isLamdaTest)
        {
            LamdaTestUtlity.quitSession();
        }
        else {
            BrowserUtility.closeBrowser();
        }
    }
}
