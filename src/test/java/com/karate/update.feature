@parallel=false
Feature: junit5 test

  Background:
    * url 'http://localhost:8080/product'

  Scenario:

    * def date = {"dateStart":1967.07.29, "dateEnd":2012.12.12}

    Given params date
    When method get
    Then status 200

    * def id = ""
    * def fun = function(x){ if(x.dateTimeCreate == "1111-01-01 11:11:11") {id = x.id}}
    * karate.forEach(response, fun)
    * def res = karate.toString(id)

    * def req = ({id:res,price:58.2,datePurchase:"1967-07-29",amount:21})

    Given request req
    When method PUT
    Then status 200
