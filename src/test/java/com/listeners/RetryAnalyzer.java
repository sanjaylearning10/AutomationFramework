package com.listeners;

import com.enums.Environment;
import com.utility.JsonUtil;
import com.utility.PropertyFileUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.Properties;

public class RetryAnalyzer implements IRetryAnalyzer {

   // private static final int MAX_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertyFileUtil.getApplicationProperty(Environment.QA,"MAX_NUMBER_OF_ATTEMPTS"));
    private static final int MAX_NUMBER_OF_ATTEMPTS= JsonUtil.readJson().getMAX_NUMBER_OF_ATTEMPTS();
    private static  int currentAttempt=1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentAttempt<=MAX_NUMBER_OF_ATTEMPTS)
        {
            currentAttempt++;
            return true;
        }
        return false;
    }
}
