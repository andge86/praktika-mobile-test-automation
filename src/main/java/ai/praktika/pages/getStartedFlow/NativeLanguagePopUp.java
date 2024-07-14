package ai.praktika.pages.getStartedFlow;

import ai.praktika.enums.Language;
import ai.praktika.pages.BasePage;
import ai.praktika.utils.ElementActionUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static ai.praktika.utils.ElementActionUtils.*;

public class NativeLanguagePopUp extends BasePage {

        // These two locators need to be changed when proper unique resource-id would be added (ask developers to add)

        @AndroidFindBy(xpath = "//*[@resource-id='ui_bsButton_SwitchTo']/*[1]")
        private WebElement buttonSwitchTo;

        @AndroidFindBy(xpath = "//*[@resource-id='ui_bsButton_SwitchTo']/*[2]")
        private WebElement buttonKeepEnglish;

    public NativeLanguagePopUp(AppiumDriver driver) {
        super(driver);
    }


    @Step
        public HobbiesAndInterestsPage tapOnButtonSwitchTo() {
            elementActionUtils.waitAndTap(buttonSwitchTo);
            return new HobbiesAndInterestsPage(driver);
        }

        @Step
        public HobbiesAndInterestsPage tapOnButtonKeepEnglish() {
            elementActionUtils.waitAndTap(buttonKeepEnglish);
            return new HobbiesAndInterestsPage(driver);
        }

        @Step
        public String getTextFromButtonSwitchTo() {
            return elementActionUtils.waitAndGetTextByAttribute(buttonSwitchTo, "content-desc");
        }

}
