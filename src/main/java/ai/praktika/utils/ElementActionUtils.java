package ai.praktika.utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActionUtils {

    // We will use implicit waits for all the interactions. Explicit wait is commented in DriverManager class
    private final WebDriverWait wait;

     public ElementActionUtils(AppiumDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
     }

    /**
     * Uses explicit wait until element to be clickable and clicks on it
     *
     * @param element to be tapped
     */
    public void waitAndTap(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Uses explicit wait until element to be located by xpath and clicks on it
     *
     * @param xpath is used to find element by xpath
     */
    public void waitAndTapByXPath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }

    /**
     * Uses explicit wait until element to be clickable, clears the text if present and types the text into it
     *
     * @param element is used to find element by xpath
     * @param text is typed into the element
     */
    public void waitAndTypeText(WebElement element, String text) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Uses explicit wait until element is visible and returns attribute value as String without next line formatting
     *
     * @param element to fetch the attribute text from
     * @param attribute defines which attribute's value to return
     * @return the String value of element's attribute as one line text
     */
    public String waitAndGetTextByAttribute(WebElement element, String attribute) {
        String text = wait.until(ExpectedConditions.visibilityOf(element)).getAttribute(attribute);
        Allure.addAttachment("Attribute " + attribute + " has name", text);
        return text
                .replaceAll("\n", " "); // Removing next line formatting for easier assertions
    }

}
