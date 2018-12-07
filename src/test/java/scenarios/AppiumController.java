package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AppiumController {

    /**
     * Establish option to run Test. Typically, we want to run it on
     * - ANDROID (REAL DEVICE)
     * - IOS (REAL DEVICE)
     * - ANDROID_EMULATOR (EMULATOR FROM Android Studio or Xcode)
     * - IOS_EMULATOR (EMULATOR FROM Xcode Mac)
     * - OR BROWSERSTACK
     */
    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
        IOS,
        IOS_BROWSERSTACK,
        ANDROID_Emulator

    }

    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            System.out.print("driver: "+driver);
            return;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (executionOS) {
            case ANDROID:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app");
                File app = new File(appDir, "app-release.apk");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "7.0");
                capabilities.setCapability("deviceName", "Soney F3116");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "pro.stksxd.sotayxaydung");
                capabilities.setCapability("appActivity", "lorence.construction.view.activity.splash.SplashActivity");
                driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                break;
            case ANDROID_Emulator:
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app");
                app = new File(appDir, "app-release.apk");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "8.0");
                capabilities.setCapability("deviceName", "Nexus 5X API 26");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "lorence.construction");
                capabilities.setCapability("appActivity", "lorence.construction.view.activity.splash.SplashActivity");
                capabilities.setCapability("noReset", "false");
                capabilities.setCapability("fullReset", "true");
                driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                break;
        }
        if (executionOS.equals(OS.IOS) || executionOS.equals(OS.IOS_BROWSERSTACK)) {
            // for click on dialog allow notification in iOS
            IOSElement textButton = (IOSElement) new WebDriverWait(driver, 5).until(
                    elementToBeClickable(MobileBy.AccessibilityId("Allow")));
            textButton.click();
        }
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
