package ai.praktika.pages.getStartedFlow;

import ai.praktika.pages.BasePage;
import ai.praktika.enums.Gender;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class GenderPage extends BasePage {

    public GenderPage(AppiumDriver driver) {
        super(driver);
    }


    @Step
    public AgePage tapOnButtonGender(Gender gender) {
        elementActionUtils.waitAndTapByXPath("//*[@resource-id = 'ui_button_" + gender.getDisplayName() + "']");
        return new AgePage(driver);
    }

}
