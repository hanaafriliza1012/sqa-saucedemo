Feature: Checkout Product

  Scenario: User checkout order chart on the product being added
    Given User already login
    And Dashboard displays several products
    When Click add to chart button on the desired product
    And Click chart
    And Click button checkout
    Then User directed to checkout information
