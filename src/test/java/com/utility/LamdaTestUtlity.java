package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LamdaTestUtlity
{
    private static final String LAMDA_TEST_URL="https://hub.lambdatest.com/wd/hub";

    private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<>();

    private static ThreadLocal<DesiredCapabilities> desiredCapabilitiesLocal=new ThreadLocal<DesiredCapabilities>();

    public static WebDriver initializeLambdaTestSession(String browser, String testName)  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "sanjaylearning10");
        ltOptions.put("accessKey", "LT_VA5pxXGFvsmeNklDILuzoFdw5nxyaoJJIZD31FJoPFYINVK");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        desiredCapabilitiesLocal.set(capabilities);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(LAMDA_TEST_URL), desiredCapabilitiesLocal.get());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driverLocal.set(driver);
        return driverLocal.get();
        
    }
    public static void quitSession()
    {
        if(driverLocal.get()==null)
        {
            driverLocal.get().quit();
        }
    }

}
