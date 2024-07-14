package ai.praktika.pages.getStartedFlow;

import ai.praktika.pages.BasePage;
import ai.praktika.pages.getStartedFlow.modules.ProgressModule;
import ai.praktika.utils.ElementActionUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class HobbiesAndInterestsPage extends BasePage {

    public ProgressModule progressModule;

    @AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View/android.view.View[2]")
    private WebElement textMainHeader;

    //TODO: ask developers to add unique locator

    public HobbiesAndInterestsPage(AppiumDriver driver) {
        super(driver);
        progressModule = new ProgressModule(driver);
    }


    @Step
    public String getTextFromMainHeader() {
      return elementActionUtils.waitAndGetTextByAttribute(textMainHeader, "content-desc")
              .replaceAll("\n", " ");
    }

}
