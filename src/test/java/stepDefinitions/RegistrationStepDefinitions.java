package stepDefinitions;

import utils.SeleniumUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationStepDefinitions {

    private WebDriver driver;
    private RegisterPage registerPage;

    public RegistrationStepDefinitions(){
        driver = SeleniumUtil.getWebDriver();
        registerPage = new RegisterPage(driver);
    }

    @When("I leave the form blank and submit the form")
    public void leaveTheFormBlankAndSubmitTheForm() {
        registerPage.clickRegisterButton();
    }

    @Then("Validation should fire for each empty field")
    public void validationShouldFireForEachEmptyField() {
        Assert.assertTrue(registerPage.registerValidationIsDisplayed());

    }

    @And("I fill in the registration form with valid details and submit the form")
    public void fillInTheRegistrationFormWithValidDetailsAndSubmitTheForm() {

        registerPage.setRegisterField(registerPage.firstName,"Test First Name");
        registerPage.setRegisterField(registerPage.lastName,"Test Last Name");
        registerPage.setRegisterField(registerPage.addressField,"Test Address Field");
        registerPage.setRegisterField(registerPage.cityField,"Test City Field");
        registerPage.setRegisterField(registerPage.stateField,"Test State Field");
        registerPage.setRegisterField(registerPage.zipCode,"Test Zip Code Field");
        registerPage.setRegisterField(registerPage.socialSecurity,"Test SSN Field");
        String randomUsername = RandomStringUtils.randomAlphabetic(6);
        registerPage.setRegisterField(registerPage.userName,randomUsername);
        registerPage.setRegisterField(registerPage.passwordField,"Test123");
        registerPage.setRegisterField(registerPage.passwordConfirmation,"Test123");
        registerPage.clickRegisterButton();
    }

    @Then("I should see the confirmation message {string}")
    public void shouldSeeTheConfirmationMessage(String string) {
        assertTrue(registerPage.confirmationMessage.getText().contains(string));
    }

    @When("I click on the Open New Account link")
    public void clickOnTheOpenNewAccountLink() {
        registerPage.clickOpenNewAccountLink();
    }
}
