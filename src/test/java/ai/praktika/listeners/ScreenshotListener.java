package ai.praktika.listeners;

import ai.praktika.managers.DriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File file = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment("Screenshot on failure", FileUtils.openInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
