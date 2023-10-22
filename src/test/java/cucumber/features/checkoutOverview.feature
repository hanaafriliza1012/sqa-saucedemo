Feature: Checkout Overview
  @Positive
  Scenario: User checkout the product by filling in the information fields validly
    Given User login
    And Go to chart
    And Go to button checkout
    And User on the checkout information page
    When User input firstname field
    And Input lastname field
    And Input postal code field
    And Click continue button
    Then Checkout overview displayed
