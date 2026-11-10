package com.utility;

import com.enums.BrowserName;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }
    public BrowserUtility(WebDriver driver) {
       super();
       this.driver.set(driver);

    }

    public BrowserUtility(String browserName) {
        if(browserName.equalsIgnoreCase(BrowserName.CHROME.toString()))
        {
            ChromeOptions chromeOptions=new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(chromeOptions));
        }
        else {
            System.err.println("Please provide correct browser name");
        }
    }

    public BrowserUtility(String browserName, boolean isHeadless) {
        if(browserName.equalsIgnoreCase(BrowserName.CHROME.toString()) && isHeadless)
        {
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--window-size=1920,1080");
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(chromeOptions));
        }
        else {
            System.err.println("Please provide correct browser name");
        }
    }
    public void openApplication(String url)
    {
     getDriver().get(url);
    }

    public void maximizeApplication()
    {
        driver.get().manage().window().maximize();
    }

    public WebElement findElement(By locator)
    {
        return driver.get().findElement(locator);
    }

    public static void closeBrowser()
    {
        driver.get().quit();
    }

    public void clickOn(By Locator)
    {
        driver.get().findElement(Locator).click();

    }
    public void enterText(By Locator,String text)
    {
        driver.get().findElement(Locator).sendKeys(text);

    }

    public  String takeScreenshot(String name)
    {
       TakesScreenshot screenshot= (TakesScreenshot) driver.get();
       File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
       Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        String timestamp=simpleDateFormat.format(date);
        String filepath=System.getProperty("user.dir")+ "\\screenshot\\"+name+"_"+timestamp+".png";
        File screenshotFile=new File(filepath);
        try {
            FileUtils.copyFile(screenshotData,screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filepath;
    }

}
