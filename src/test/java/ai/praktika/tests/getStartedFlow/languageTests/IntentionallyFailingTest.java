package ai.praktika.tests.getStartedFlow.languageTests;

import ai.praktika.tests.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Customer Get Started Flow")
@Feature("Intentionally failing feature")
public class IntentionallyFailingTest extends BaseTest {

    @Story("Intentionally failing story")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Andrii N")
    @Test(testName = "Intentionally failing feature with screenshot on failure",
            description = "Intentionally failing feature test to see the screenshot on failure")
    public void intentionallyFailingFeatureTest() {
        Assert.fail("Intentionally failing feature test to see the screenshot on failure");
    }
}
