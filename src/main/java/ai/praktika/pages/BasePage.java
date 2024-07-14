package ai.praktika.pages;

import ai.praktika.utils.ElementActionUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected AppiumDriver driver;
    protected ElementActionUtils elementActionUtils;


    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        elementActionUtils = new ElementActionUtils(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
