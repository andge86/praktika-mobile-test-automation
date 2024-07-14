package ai.praktika.utils;

import io.qameta.allure.Step;

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

}
