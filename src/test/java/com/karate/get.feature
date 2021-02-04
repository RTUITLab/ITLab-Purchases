Feature: junit5 test

  Scenario:
    Given url 'http://localhost:8080/product'
    When method get
    Then status 200