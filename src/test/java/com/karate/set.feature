@parallel=false
Feature: junit5 test

  Background:
    * url 'http://localhost:8080/product'

  Scenario:

    * def p = [{"name":"Кресло","price":54.2,"datePurchase":"1967-07-29","amount":11, "dateTimeCreate": "1111-01-01 11:11:11", "userName":"Ваня"},{"name":"Парта","price":12.1,"datePurchase":"2012-12-12","amount":12, "dateTimeCreate": "1111-01-01 11:11:11","userName":"Петя"}]

    Given request p
    When method POST
    Then status 200