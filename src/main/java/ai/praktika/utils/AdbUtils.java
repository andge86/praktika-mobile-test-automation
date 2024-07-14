package ai.praktika.utils;

import io.qameta.allure.Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdbUtils {

    // Quick solution to install the app using multiple .apk files received from Google Play
    @Step
    public static void installApp() {
        String appDir = System.getProperty("user.dir") + "/apps/";
        try {
            Process process = Runtime.getRuntime()
                    .exec("adb install-multiple " + appDir + "/base.apk " + appDir + "split_config.en.apk " + appDir + "split_config.ar.apk " + appDir + "split_config.arm64_v8a.apk " + appDir + "split_config.xxhdpi.apk");
            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step
    public static void listInstalledPackages() {
        try {
            // Execute the ADB command to list packages
            Process process = Runtime.getRuntime().exec("adb shell pm list packages");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Read and print each line of output
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each package name
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
