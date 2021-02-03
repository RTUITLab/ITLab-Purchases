  Feature: junit5 test

    Background:
      * url 'https://localhost:8080'

    Scenario:
      * print 'test'
      Given url 'http://localhost:8080/get'
      When method get
      Then status 200