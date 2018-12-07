package pages;

import io.appium.java_client.AppiumDriver;

public class BasePage {
    protected AppiumDriver appiumDriver;

    public BasePage(AppiumDriver driver) {
        this.appiumDriver = driver;
    }

    public void lauchApp() {
        appiumDriver.launchApp();
    }

    public void closeApp() {
        appiumDriver.closeApp();
    }
}
