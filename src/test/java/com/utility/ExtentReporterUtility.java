package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {

   private static ExtentSparkReporter extentSparkReporter;

    private static  ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
    private static ExtentReports extentReports;

    public static void setSparkRepork(String reportName)
    {
        extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//"+reportName);
        extentReports =new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void createExtentTest(String testName)
    {
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }
    public static ExtentTest getTest()
    {
        return extentTest.get();
    }

    public static void flushReport()
    {
        extentReports.flush();
    }
}

