Feature: Cucumber test

Background:
Given Browser is opened

Scenario Outline: Search using different words.
Scenario: login
    Given User navigates to "http://www.google.com.ar"
    When User enters <texto> and clicks on search
    Then Search results page is opened

 Examples:
|texto|
|busqueda 1|
|prueba 1|