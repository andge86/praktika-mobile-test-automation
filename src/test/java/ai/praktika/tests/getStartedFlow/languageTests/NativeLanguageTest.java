package ai.praktika.tests.getStartedFlow.languageTests;

import ai.praktika.tests.BaseTest;
import ai.praktika.enums.Age;
import ai.praktika.enums.Language;
import ai.praktika.managers.DriverManager;
import ai.praktika.pages.WelcomePage;
import ai.praktika.enums.Gender;
import ai.praktika.pages.getStartedFlow.HobbiesAndInterestsPage;
import ai.praktika.pages.getStartedFlow.NativeLanguagePage;
import ai.praktika.pages.getStartedFlow.NativeLanguagePopUp;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.Iterator;

@Epic("Customer Get Started Flow")
@Feature("Multi Languages Support")
public class NativeLanguageTest extends BaseTest {

    @DataProvider(name = "LanguagesData")
    public Iterator<Language> provideLanguagesData() {
        return Arrays.asList(
                Language.ITALIAN,
                Language.SPANISH
        ).iterator();
    }

    @Story("Change application interface language")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Andrii N")
    @Test(testName = "Interface language change", description = "User is able to change interface language", dataProvider = "LanguagesData")
    public void changingTolOtherLanguageInterfaceTest(Language language) {
        NativeLanguagePopUp nativeLanguagePopUp =
                navigateToNativeLanguagePage(Gender.MALE, Age.AGE_35_44, "Andrii")
                        .chooseFullySupportedLanguage(language, true);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nativeLanguagePopUp.getTextFromButtonSwitchTo(), "Switch to " + language.getDisplayName(),
                "Button text is not 'Switch to " + language.getDisplayName() + "'");

        HobbiesAndInterestsPage hobbiesAndInterestsPage = nativeLanguagePopUp.tapOnButtonSwitchTo();
        softAssert.assertEquals(hobbiesAndInterestsPage.getTextFromMainHeader(), language.getHobbyAndInterestsQuestion(),
                "HobbiesAndInterestsPage was not translated to " + language.getDisplayName() + " language");

        NativeLanguagePage nativeLanguagePage = hobbiesAndInterestsPage.progressModule.tapOnArrowBack();
        softAssert.assertEquals(nativeLanguagePage.getTextFromMainHeader(), language.getMotherTongueQuestion(),
                "NativeLanguagePage was NOT translated to " + language.getDisplayName() + " language");
        softAssert.assertAll();
    }

    @Story("Keep English as application language interface")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Andrii N")
    @Test(testName = "Keeping English language interface", description = "User is able to keep interface language as English")
    public void keepingEnglishLanguageInterfaceTest() {
        Language language = Language.ITALIAN;

        NativeLanguagePopUp nativeLanguagePopUp =
                navigateToNativeLanguagePage(Gender.FEMALE, Age.AGE_UNDER_18, "Bianca")
                        .chooseFullySupportedLanguage(language, true);

        // Here used soft assert which won't fail the test when single assert fails, but will proceed to the end of the test
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nativeLanguagePopUp.getTextFromButtonSwitchTo(), "Switch to " + language.getDisplayName(),
                "Button text is not 'Switch to " + language.getDisplayName() + "'");

        HobbiesAndInterestsPage hobbiesAndInterestsPage = nativeLanguagePopUp.tapOnButtonKeepEnglish();
        softAssert.assertEquals(hobbiesAndInterestsPage.getTextFromMainHeader(),
                Language.ENGLISH.getHobbyAndInterestsQuestion().replace(Language.ENGLISH.getGreeting(), language.getGreeting()),
                "HobbiesAndInterestsPage has not ONLY greeting word translated to " + language.getDisplayName() + " language");

        NativeLanguagePage nativeLanguagePage = hobbiesAndInterestsPage.progressModule.tapOnArrowBack();
        softAssert.assertEquals(nativeLanguagePage.getTextFromMainHeader(), Language.ENGLISH.getMotherTongueQuestion(),
                "NativeLanguagePage was translated to " + language.getDisplayName() + " language");
        softAssert.assertAll();
    }

    @Story("Customer chooses partially supported language")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Andrii N")
    @Test(testName = "Keeping English language interface for partially supported language", description = "User gets English interface language for partially supported language")
    public void keepingEnglishLanguageInterfaceForPartiallySupportedLanguageTest() {

        Language language = Language.DUTCH;

        HobbiesAndInterestsPage hobbiesAndInterestsPage =
                navigateToNativeLanguagePage(Gender.PREFER_NOT_TO_SAY, Age.AGE_65_AND_OVER, "Peter")
                        .choosePartiallySupportedLanguage(language, false);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(hobbiesAndInterestsPage.getTextFromMainHeader(),
                Language.ENGLISH.getHobbyAndInterestsQuestion().replace(Language.ENGLISH.getGreeting(), language.getGreeting()),
                "HobbiesAndInterestsPage has not ONLY greeting word translated to " + language.getDisplayName() + " language");

        NativeLanguagePage nativeLanguagePage = hobbiesAndInterestsPage.progressModule.tapOnArrowBack();
        softAssert.assertEquals(nativeLanguagePage.getTextFromMainHeader(), Language.ENGLISH.getMotherTongueQuestion(),
                "NativeLanguagePage was translated to " + language.getDisplayName() + " language");
        softAssert.assertAll();
    }

    // Common steps for all the tests for entire test class, used to optimize the code maintainability
    private NativeLanguagePage navigateToNativeLanguagePage(Gender gender, Age age, String name) {
        return new WelcomePage(DriverManager.getDriver())
                .tapOnButtonGetStarted()
                .tapOnButtonGender(gender)
                .tapOnButtonAge(age)
                .typeIntoTextFieldName(name)
                .tapOnButtonContinue();
    }

}