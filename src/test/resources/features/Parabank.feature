@ross
Feature: Parabank home page

  Scenario: Validation fires on Register for a new account
    Given I am on the Parabank home page
    When I click on the Register link
    And I leave the form blank and submit the form
    Then Validation should fire for each empty field

  Scenario: Register for a new account
    Given I am on the Parabank home page
    When I click on the Register link
    And I fill in the registration form with valid details and submit the form
    Then I should see the confirmation message "Your account was created successfully. You are now logged in."

  Scenario: Open a new savings account
    Given I check the balance of Checking account is "$50000.00"
    When I click on the Open New Account link
    And I select Savings and Open New Account
    And I click on the Accounts Overview link
    Then The Available Amount of Checking Account is now "$49999.00"
    And The Available Amount of Savings Account is "$1.00"

  Scenario: Transfer funds from one account to another
    Given I click on the Transfer Funds link
    And I transfer $1 from Checking Account to Savings Account
    And I click on the Accounts Overview link
    Then The Available Amount of Checking Account is now "$49998.00"
    And The Available Amount of Savings Account is "$2.00"

  Scenario: Pay a bill from Checking Account
    Given I click on the Bill Pay link
    When I pay a bill of $50.00
    And I click on the Accounts Overview link
    Then I check the balance of Checking account is "$49948.00"
    And I logout and close browser