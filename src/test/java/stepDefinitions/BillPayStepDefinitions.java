package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BillPayPage;
import utils.SeleniumUtil;

public class BillPayStepDefinitions {

    private WebDriver driver;
    private BillPayPage billPayPage;

    public BillPayStepDefinitions(){
        driver = SeleniumUtil.getWebDriver();
        billPayPage = new BillPayPage(driver);
    }

    @Given("I click on the Bill Pay link")
    public void clickOnTheBillPayLink() {
        billPayPage.clickBillPayLink();
    }

    @When("I pay a bill of $50.00")
    public void fillInPayBill() {

        billPayPage.setBillPayField(billPayPage.payeeName,"Test Name");
        billPayPage.setBillPayField(billPayPage.payeeAddress,"Test Address Field");
        billPayPage.setBillPayField(billPayPage.payeeCity,"Test City Field");
        billPayPage.setBillPayField(billPayPage.payeeState,"Test State Field");
        billPayPage.setBillPayField(billPayPage.payeeZipCode,"Test Zip Code Field");
        billPayPage.setBillPayField(billPayPage.payeePhone,"0800100");
        billPayPage.setBillPayField(billPayPage.payeeAccount,"1234");
        billPayPage.setBillPayField(billPayPage.payeeVerifyAccount,"1234");
        billPayPage.setBillPayField(billPayPage.payeeAmount,"50");
        billPayPage.setBillPayField(billPayPage.payeePhone,"0800100");
        billPayPage.clickSendPaymentButton();
    }
}
