package stepDefinitions;

import cucumber.api.java.en.And;
import io.github.sridharbandi.AccessibilityRunner;
import org.junit.Test;
import utils.SeleniumUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.io.IOException;

public class HomePageStepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private static AccessibilityRunner htmlCsRunner;
    private RegistrationStepDefinitions registrationStepDefinitions;


    public HomePageStepDefinitions(){
        driver = SeleniumUtil.getWebDriver();
        homePage = new HomePage(driver);
        htmlCsRunner = new AccessibilityRunner(driver);
        registrationStepDefinitions = new RegistrationStepDefinitions();
    }
    @Test
    @Given("I am on the Parabank home page")
    public void amOnTheParabankHomePage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @When("I click on the Register link")
    public void clickOnTheRegisterLink() {
        homePage.clickRegisterLink();
    }

    @Given("I am logged in as a user on Parabank")
    public void amLoggedInAsAUserOnParabank() {
       amOnTheParabankHomePage();
       clickOnTheRegisterLink();
       registrationStepDefinitions.fillInTheRegistrationFormWithValidDetailsAndSubmitTheForm();
       registrationStepDefinitions.shouldSeeTheConfirmationMessage("Your account was created successfully. You are now logged in.");
    }

    @And("I logout and close browser")
    public void logoutAndCloseBrowser() throws IOException {
        homePage.clickLogOutLink();
        htmlCsRunner.execute();
        htmlCsRunner.generateHtmlReport();
        driver.close();
        driver.quit();
    }
}
