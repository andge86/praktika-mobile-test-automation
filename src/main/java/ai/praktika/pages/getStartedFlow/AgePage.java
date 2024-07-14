package ai.praktika.pages.getStartedFlow;

import ai.praktika.enums.Age;
import ai.praktika.pages.BasePage;
import ai.praktika.utils.ElementActionUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

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
