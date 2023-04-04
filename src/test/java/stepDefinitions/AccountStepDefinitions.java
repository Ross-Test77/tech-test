package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import utils.SeleniumUtil;

import static org.junit.Assert.assertTrue;

public class AccountStepDefinitions {

    private WebDriver driver;
    private AccountPage accountPage;

    public AccountStepDefinitions(){
        driver = SeleniumUtil.getWebDriver();
        accountPage = new AccountPage(driver);
    }

    @And("I select Savings and Open New Account")
    public void selectSavingsAndOpenNewAccount() throws Exception {
        accountPage.selectSavingsAccountType();
        Thread.sleep(1000);
        accountPage.clickOpenNewAccountButton();
        Thread.sleep(1000);
    }

    @When("I click on the Accounts Overview link")
    public void clickOnTheAccountsOverviewLink() {
        accountPage.clickAccountOverviewLink();
    }

    @And("I check the balance of Checking account is {string}")
    public void checkBalanceOfCheckingAccount(String string) throws Exception {
        accountPage.clickAccountOverviewLink();
        accountPage.clickCheckingAccountLink();
        Thread.sleep(1000);
        assertTrue(accountPage.checkingAccountBalance.getText().contains(string));
    }

    @Then("The Available Amount of Checking Account is now {string}")
    public void checkBalanceOfCheckingAccountAfterDeduction(String string) throws Exception {
        accountPage.clickAccountOverviewLink();
        accountPage.clickCheckingAccountLink();
        Thread.sleep(1000);
        assertTrue(accountPage.checkingAccountBalance.getText().contains(string));
    }

    @And("The Available Amount of Savings Account is {string}")
    public void checkBalanceOfSavingsAccount(String string) throws Exception {
        accountPage.clickAccountOverviewLink();
        accountPage.clickSavingsAccountLink();
        Thread.sleep(1000);
        assertTrue(accountPage.savingsAccountText.getText().contains("SAVINGS"));
        Thread.sleep(1000);
        assertTrue(accountPage.savingsAccountBalance.getText().contains(string));
    }
}
