package tests.base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        log.debug(String.format("======================================== STARTING TEST %s ========================================", iTestResult.getName()));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.debug(String.format("======================================== FINISHED TEST %s Duration: %ss ========================================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.debug(String.format("======================================== FAILED TEST %s Duration: %ss ========================================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
        takeScreenshot(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.debug(String.format("======================================== SKIPPING TEST %s ========================================", iTestResult.getName()));
        takeScreenshot(iTestResult);
    }

    private void takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if (driver != null) {
                log.info("Take screenshot test: {}", iTestResult.getName());
                AllureUtils.takeScreenshot(driver);
            }
        } catch (NoSuchSessionException | IllegalStateException ignored) {
        }
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
