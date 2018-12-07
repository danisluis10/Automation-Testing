package pages.demo;

import io.appium.java_client.AppiumDriver;
import pages.BasePage;

public class DemoPage extends BasePage {

    public DemoPage(AppiumDriver driver) {
        super(driver);
    }

    public void TestCaseNo1() {
        lauchApp();
    }
}
