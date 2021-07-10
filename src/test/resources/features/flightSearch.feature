Feature:  As a user, I want to search some flights and select one them

  Scenario Outline: Search and select flight
    When  Search some flight with "<jsonName>" "<numTestCase>"
    Then Select flight

    Examples:
      | jsonName     | numTestCase |
      | searchFlight | 1           |