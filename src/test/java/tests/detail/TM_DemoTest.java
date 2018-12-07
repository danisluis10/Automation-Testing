package tests.detail;

import org.testng.annotations.Test;
import scenarios.config.AppBaseClass;

public class TM_DemoTest extends AppBaseClass {

    @Test(priority = 1)
    public void DemoTCNo1() {
        demoPage.TestCaseNo1();
    }

}
