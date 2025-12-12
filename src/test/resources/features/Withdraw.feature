@Withdraw
Feature: Withdraw money

  Background:
    Given User opens the Digital Bank site
    And User accept cookies
    And the user logs in with "jsmith" and "Demo123!"

  @TC_03_01
  Scenario: Successful withdraw
    When the user withdraws 25 from account "ACC1"
    Then a success message should be displayed

  @TC_03_02
  Scenario: Withdraw with empty amount
    When the user tries to withdraw with empty amount from "ACC1"
    Then an error message should be displayed

  @TC_03_03
  Scenario: Withdraw with no selected account
    When the user tries to withdraw 25 with no account selected
    Then an error message should be displayed