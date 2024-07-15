package ai.praktika.pages.getStartedFlow;

import ai.praktika.enums.Age;
import ai.praktika.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class AgePage extends BasePage {

    public AgePage(AppiumDriver driver) {
        super(driver);
    }


    @Step
    public NamePage tapOnButtonAge(Age age) {
        elementActionUtils.waitAndTapByXPath("//*[@resource-id = 'ui_button_age" + age.getDisplayName() + "']");
        return new NamePage(driver);
    }

}
