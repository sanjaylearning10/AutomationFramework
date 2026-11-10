package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;


public class ITestListner implements ITestListener {

    Logger logger= LoggerUtility.getLogger(this.getClass());

    public void onTestStart(ITestResult result) {
    logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
       ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReporterUtility.getTest().log(Status.PASS,result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        ExtentReporterUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName());
        logger.error(result.getThrowable().getMessage());
       Object object= result.getInstance();
       BrowserUtility browserUtility= ((TestBase)object).getInstance();
       String filePath=browserUtility.takeScreenshot(result.getMethod().getMethodName());
        ExtentReporterUtility.getTest().addScreenCaptureFromPath(filePath);
    }

    public void onTestSkipped(ITestResult result) {
        ExtentReporterUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName());
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite started...");
        ExtentReporterUtility.setSparkRepork("report.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite completed...");
        ExtentReporterUtility.flushReport();
    }
}
