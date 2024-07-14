package ai.praktika.tests;

import ai.praktika.managers.DriverManager;
import ai.praktika.utils.AdbUtils;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    @Parameters({"platformName", "run"})
    public void setUp(@Optional("Android") String platformName, @Optional("local") String run) {
        AdbUtils.installApp();
        DriverManager.initializeDriver(platformName, run);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
