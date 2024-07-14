package ai.praktika.pages.getStartedFlow;

import ai.praktika.enums.Language;
import ai.praktika.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class NativeLanguagePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
    private WebElement textMainHeader;

    @AndroidFindBy(xpath = "//*[@resource-id = 'ui_textEdit_Search']")
    private WebElement textFieldSearch;

    public NativeLanguagePage(AppiumDriver driver) {
        super(driver);
    }


    @Step
    public NativeLanguagePopUp chooseFullySupportedLanguage(Language language, boolean isVisible) {
        if (isVisible) elementActionUtils.waitAndTapByXPath("//*[@resource-id = 'ui_button_" + language.getDisplayName() + "']");
        else searchForAndConfirm(language);
        return new NativeLanguagePopUp(driver);
    }

    public HobbiesAndInterestsPage choosePartiallySupportedLanguage(Language language, boolean isVisible) {
      if (isVisible) elementActionUtils.waitAndTapByXPath("//*[@resource-id = 'ui_button_" + language.getDisplayName() + "']");
      else searchForAndConfirm(language);
      return new HobbiesAndInterestsPage(driver);
    }

    @Step
    public String getTextFromMainHeader() {
        return elementActionUtils.waitAndGetTextByAttribute(textMainHeader, "content-desc")
                .replaceAll("\n", " ");
    }

    private void searchForAndConfirm(Language language) {
        elementActionUtils.waitAndTap(textFieldSearch);
        elementActionUtils.waitAndTypeText(textFieldSearch, language.getDisplayName());
        elementActionUtils.waitAndTapByXPath("//*[@resource-id = 'ui_button_" + language.getDisplayName() + "']");
    }

    // TODO: we can also implement scrolling logic in addition to using search functionality

}
