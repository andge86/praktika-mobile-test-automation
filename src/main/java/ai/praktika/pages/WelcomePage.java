package ai.praktika.pages;

import ai.praktika.pages.getStartedFlow.GenderPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {

    @AndroidFindBy(xpath = "//*[@content-desc='GetStarted Button']")
    private WebElement buttonGetStarted;

    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }


    @Step
    public GenderPage tapOnButtonGetStarted() {
        elementActionUtils.waitAndTap(buttonGetStarted);
        return new GenderPage(driver);
    }

}
