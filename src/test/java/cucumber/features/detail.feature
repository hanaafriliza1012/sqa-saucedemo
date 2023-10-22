Feature: Product Detail

  Scenario: User view product detail
    Given User success login
    And Directed to several products
    When Select a product
    Then See the product details