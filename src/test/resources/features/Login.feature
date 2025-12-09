@US1
@LoginFeature
Feature: User Login

  A registered user wants to log in.

  Background:
    Given User opens the Digital Bank site
    And User accept cookies

  Rule: Valid users can log in successfully.

    @TC_02_01_01
    @ValidLogin
    Scenario: Successful login
      When the user enters "test1" as username
      And the user enters "Pass1" as password
      And the user clicks the Login button
      Then the dashboard should be displayed

     @InvalidAC
     @AcceptanceCriteria_02_02
     Rule: Invalid credentials result in error

     @TC_02_02_01
     @InvalidLogin
     Scenario Outline: Invalid logins
      When the user enters a "<username>" and "<password>"
      And the user clicks the Login button
      Then an error message should be displayed

      Examples:
       | username | password |
       | test1    | Pass1    |
       | test1    |          |
       |          | Pass1    |
