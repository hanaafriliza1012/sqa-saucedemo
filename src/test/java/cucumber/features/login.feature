Feature: Login website saucedemo

  Scenario: User can login using registered username and password
    Given Login page saucedemo
    When User input registered username
    And Input registered password
    And Click login button
    Then User direct to dashboard

  Scenario: User can't login using unregistered password
    Given Login page saucedemo
    When User input registered username
    And Input unregistered password
    And Click login button
    Then Error message displayed