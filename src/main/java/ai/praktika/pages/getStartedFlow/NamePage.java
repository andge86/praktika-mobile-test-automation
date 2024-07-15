package ai.praktika.pages.getStartedFlow;

import ai.praktika.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class NamePage extends BasePage {

    @AndroidFindBy(xpath = "//*[@resource-id = 'ui_textEdit_Name']")
    private WebElement textFieldName;

    @AndroidFindBy(xpath = "//*[@resource-id = 'ui_button_Continue']")
    private WebElement buttonContinue;

    public NamePage(AppiumDriver driver) {
        super(driver);
    }


    @Step
    public NamePage typeIntoTextFieldName(String name) {
        elementActionUtils.waitAndTap(textFieldName);
        elementActionUtils.waitAndTypeText(textFieldName, name);
        return this;
    }

    @Step
    public NativeLanguagePage tapOnButtonContinue() {
        elementActionUtils.waitAndTap(buttonContinue);
        return new NativeLanguagePage(driver);
    }

}
