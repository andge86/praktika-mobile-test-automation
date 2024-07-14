package ai.praktika.tests;

import ai.praktika.managers.DriverManager;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {

    @BeforeMethod
    @Parameters({"platformName", "run"})
    public void setUp(@Optional("Android") String platformName, @Optional("local") String run) {
        DriverManager.initializeDriver(platformName, run);
    }

    @AfterMethod
    public void tearDown() throws IOException {
  //      attachScreenshot();
        DriverManager.quitDriver();
    }

//    private static void attachScreenshot() throws IOException {
//        File file = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//        Allure.addAttachment("Screenshot", FileUtils.openInputStream(file));
//    }

}
