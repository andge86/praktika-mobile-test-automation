package ai.praktika.pages.getStartedFlow.modules;

import ai.praktika.pages.BasePage;
import ai.praktika.pages.getStartedFlow.NativeLanguagePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

/**
 * ProgressModule is common element in the entire Get Started Flow
 * It could be added to any Page by creating its instance with driver provided
 */
public class ProgressModule extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private WebElement arrowBack;

    //TODO: ask developers to add unique locator

    public ProgressModule(AppiumDriver driver) {
        super(driver);
    }


    @Step
    public NativeLanguagePage tapOnArrowBack() {
        elementActionUtils.waitAndTap(arrowBack);
        return new NativeLanguagePage(driver);
    }

}
