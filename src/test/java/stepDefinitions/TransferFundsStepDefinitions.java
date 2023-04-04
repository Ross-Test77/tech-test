package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

import pages.TransferPage;
import utils.SeleniumUtil;

public class TransferFundsStepDefinitions {

    private WebDriver driver;
    private TransferPage transferPage;

    public TransferFundsStepDefinitions(){
        driver = SeleniumUtil.getWebDriver();
        transferPage = new TransferPage(driver);
    }

    @And("I transfer $1 from Checking Account to Savings Account")
    public void transferFromCheckingAccount() throws Exception {
        Thread.sleep(1000);
        transferPage.setTransferField(transferPage.transferFundsAmount, "1");
        Thread.sleep(1000);
        transferPage.selectTransferAccountNumber();
        transferPage.clickTransferButton();
    }

    @Given("I click on the Transfer Funds link")
    public void clickOnTheTransferFundsLink() {
        transferPage.clickTransferFundsLink();
    }

}
