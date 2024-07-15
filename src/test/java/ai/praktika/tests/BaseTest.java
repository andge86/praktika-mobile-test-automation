package ai.praktika.tests;

import ai.praktika.managers.DriverManager;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    @Parameters({"platformName", "run"})
    public void setUp(@Optional("Android") String platformName, @Optional("local") String run) {
        DriverManager.initializeDriver(platformName, run);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
