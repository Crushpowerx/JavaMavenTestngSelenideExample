package runners;

import com.codeborne.selenide.Selenide;
import config.SelenoidConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SelenoidRunner {

    @Parameters({"BROWSER"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("Chrome") String browser) {
        if (browser.equals("{$BROWSER}")) {
            browser = "Chrome";
        }
        SelenoidConfig selenoidConfig = new SelenoidConfig();
        selenoidConfig.createWebDriverInstance(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
