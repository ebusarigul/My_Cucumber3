Feature: ApachePOI Citizen Functionality
  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly
    And Navigate to Citizenship page

    Scenario: Create and Delete CitizenShip from Excel
      When User Create Citizenship with ApachePOI

      When User Delete Citizenship with ApachePOI
