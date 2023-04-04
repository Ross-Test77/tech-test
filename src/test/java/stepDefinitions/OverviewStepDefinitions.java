package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pages.OverviewPage;
import utils.SeleniumUtil;

public class OverviewStepDefinitions {


    private WebDriver driver;
    private OverviewPage overviewPage;

    public OverviewStepDefinitions(){
        driver = SeleniumUtil.getWebDriver();
        overviewPage = new OverviewPage(driver);
    }
}
