@parallel=false
Feature: junit5 test

  Background:
    * url 'http://localhost:8080/product'
    * configure headers = { 'Authentication': 'Token' }

#    Test 1
  Scenario:

    When method get
    Then status 400

#    Test 2
  Scenario:

    * def date = {"dateStart":1967-07-29, "dateEnd":2012-12-12}

    Given params date
    When method get
    Then status 200

#    Test 3
  Scenario:

    * def p = [{"name":"Кресло","price":54.2,"datePurchase":"1967-07-29","amount":11, "dateTimeCreate": "2021-04-02T13:53:26.000+00:00", "userName":"Ваня"}]

    Given request p
    When method POST
    Then status 200

#    Test 4
  Scenario:

    * def p = [{"name":"Кресло","price":54.2,"datePurchase":"1967-07-29","amount":11, "dateTimeCreate": "ert", "userName":"Ваня"}]

    Given request p
    When method POST
    Then  status 400

#    Test 5
  Scenario:

    * def date = {"dateStart":1967-07-28, "dateEnd":2012-12-11}

    Given params date
    When method get
    Then status 200

#    Test 6
  Scenario:

    * def date = {"dateStart":1967-07-28, "dateEnd":2012-12-11}

    Given params date
    When method get
    Then status 200

    * def id = ""
    * def fun = function(x){ if(x.dateTimeCreate == "2021-04-02T13:53:26.000+00:00") {id = x.id}}
    * karate.forEach(response, fun)
    * def res = karate.toString(id)

    * def req = ({id:res,price:11,datePurchase:"1967-07-29",amount:21,userName:"Володя"})

    Given request req
    When method PUT
    Then status 200

#    Test 7
  Scenario:

    * def date = {"dateStart":1967-07-28, "dateEnd":2012-12-11}

    Given params date
    When method get
    Then status 200

    * def list = ""
    * def fun = function(x){ if(x.dateTimeCreate == "2021-04-02T13:53:26.000+00:00") {list = list + "," +  x.id }}
    * karate.forEach(response, fun)
    * def res = karate.toMap(list)
    * print list
    * print res

    Given param id = res
    When method delete
    Then status 200