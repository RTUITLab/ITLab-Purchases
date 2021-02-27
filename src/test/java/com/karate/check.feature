  Feature: junit5 test

    Scenario:
      Given url 'http://localhost:8080/product/check'
      When method get
      Then status 200