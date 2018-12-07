package scenarios.config;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import pages.demo.DemoPage;
import scenarios.AppiumBaseClass;
import scenarios.AppiumController;
import utils.Constants;

public class AppBaseClass extends AppiumBaseClass {

    protected BasePage basePage;
    protected DemoPage demoPage;

    @BeforeTest
    public void setUp(ITestContext iTestContext) throws Exception {
        Constants.EXECUTING_SUITE = iTestContext.getCurrentXmlTest().getSuite().getName();
        AppiumController.instance.start();
        basePage = new BasePage(driver());
        demoPage = new DemoPage(driver());
    }

    @AfterTest
    public void tearDown() {
        AppiumController.instance.stop();
    }
}
