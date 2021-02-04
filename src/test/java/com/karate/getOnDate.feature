Feature: junit5 test

  Background:
    * url 'http://localhost:8080/product'

  Scenario:

    * def date = {"dateStart":1967.07.29, "dateEnd":2012.12.12}

    Given params date
    When method get
    Then status 200