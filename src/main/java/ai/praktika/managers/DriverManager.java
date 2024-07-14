package ai.praktika.managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * DriverManager class is responsible for maintaining thread safe instance of driver
 * It can create and set new driver instance based on platform name and run option, get it and remove it
 * Basic driver capabilities to run mobile app on Android device are included also
 */
public class DriverManager {

    // This variable is responsible to maintain thread safety of driver during parallel execution
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(String platformName, String run) {
        DesiredCapabilities capabilities = getDesiredCapabilities(platformName);
        try {
            switch (platformName + "|" + run) {
                case "Android|local" -> driver.set(new AndroidDriver(new URI("http://localhost:4723").toURL(), capabilities));
                case "Android|remote" -> driver.set(new AndroidDriver(new URI("http://remote.device.farm/wd/hub").toURL(), capabilities));
                default -> throw new RuntimeException("Only Android platformName with local run is supported");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        // Commenting this to use implicit waits in ElementActionUtils class
        //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    private static DesiredCapabilities getDesiredCapabilities(String platformName) {
        // Here I mention only base required capabilities to run automation on Android emulator
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // I do not have .apk file, so I am assuming that the latest version of app under tests is already installed
        // capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/android_praktika_app.apk");
        capabilities.setCapability("appium:appPackage", "ai.praktika.android");
        capabilities.setCapability("appium:appActivity", "ai.praktika.android.MainActivity");
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:noReset", false);

        capabilities.setCapability("appium:sessionOverride", true);
        capabilities.setCapability("appium:newCommandTimeout", 100); // 5 minutes

        return capabilities;
    }

    public static AppiumDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first preferably in BaseTest class");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
