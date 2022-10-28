Feature: Login page feature

  Background: 
    Given launch the browser
    When open the URL

  Scenario: Login page Title
    Then page title should be "Login - My Store"
    And close the browser

  Scenario: Forgot password link
    Then Forgot your password link should be displayed
    And close the browser

  Scenario: Login with correct credentials
    When user enters username "stefan_hasni@yahoo.fr" and the password "qwerty1234"
    And user clicks on Login button
    Then page title should be "My account - My Store"
    And close the browser
