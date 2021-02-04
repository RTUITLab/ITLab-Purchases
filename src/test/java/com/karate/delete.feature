@parallel=false
Feature: junit5 test

  Background:
    * url 'http://localhost:8080/product'

  Scenario:

    * def date = {"dateStart":1967.07.29, "dateEnd":2012.12.12}

    Given params date
    When method get
    Then status 200

    * def list = ""
    * def fun = function(x){ if(x.dateTimeCreate == "1111-01-01 11:11:11") {list = list + ", " + x.id }}
    * karate.forEach(response, fun)
    * def res = karate.toMap(list)

    Given param id = res
    When method delete
    Then status 200