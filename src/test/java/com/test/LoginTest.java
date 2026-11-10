package com.test;

import com.utility.BrowserUtility;
import com.utility.CsvDataReader;
import com.pages.HomePage;
import com.pogo.Credentails;
import com.utility.JsonUtil;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({com.listeners.ITestListner.class})
public class LoginTest extends  TestBase {



    @Test(description = "validate user is able to login with valid cred",groups = {"e2e","sanity"},priority = 0,dataProviderClass = com.dataprovider.JsonLoginUtil.class,dataProvider = "LoginDataprovider")
    public  void loginTest(Credentails credentails){

        homePage.openApplication(JsonUtil.readJson().getUrl());
        homePage.maximizeApplication();

       String loggedinUserName= homePage.selectLogin().doLogin(credentails.getEmail(),credentails.getPassword()).getUserName();
       System.out.println("logged in user name is :: "+loggedinUserName);
        Assert.assertEquals(loggedinUserName, "Sanjay kumar", "test is pass");
        homePage.closeBrowser();

    }
    @Test(description = "validate user is able to login with cred from csv",groups = {"e2e","sanity"},priority = 1,dataProviderClass = com.dataprovider.JsonLoginUtil.class,dataProvider = "LoginDataProviderCsv")
    public  void loginTestCsv(Credentails credentails){
        homePage.openApplication(JsonUtil.readJson().getUrl());
        homePage.maximizeApplication();
        String loggedinUserName= homePage.selectLogin().doLogin(credentails.getEmail(),credentails.getPassword()).getUserName();
        System.out.println("logged in user name is :: "+loggedinUserName);

        homePage.closeBrowser();
    }
    @Test(description = "validate user is able to login with cred from excel",groups = {"e2e","sanity"},priority = 1,dataProviderClass = com.dataprovider.JsonLoginUtil.class,dataProvider = "LoginDataProviderExcel")
    public  void loginTestExcel(Credentails credentails){
        homePage.openApplication(JsonUtil.readJson().getUrl());
        homePage.maximizeApplication();
        String loggedinUserName= homePage.selectLogin().doLogin(credentails.getEmail(),credentails.getPassword()).getUserName();
        System.out.println("logged in user name is :: "+loggedinUserName);
        homePage.closeBrowser();
    }
    @Test(description = "validate user is able to login with cred from excel and rety in case of failure",retryAnalyzer = com.listeners.RetryAnalyzer.class,dataProviderClass = com.dataprovider.JsonLoginUtil.class,dataProvider = "LoginDataProviderExcel")
    public  void loginTestRetry(Credentails credentails){
        homePage.openApplication(JsonUtil.readJson().getUrl());
        homePage.maximizeApplication();
        String loggedinUserName= homePage.selectLogin().doLogin(credentails.getEmail(),credentails.getPassword()).getUserName();
        System.out.println("logged in user name is :: "+loggedinUserName);
        Assert.assertEquals(loggedinUserName, "Sanjay kumar1", "test is pass");
        homePage.closeBrowser();
    }


}
