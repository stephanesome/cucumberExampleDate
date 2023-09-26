Feature: Next date for invalid date
  Next date should notify an error for an invalid date

  Scenario: Asking for the day after 1730/June/31 should result in an error
    Given the invalid date "1730/June/31" 
    When I ask for the next date
    Then the response should be "Input Error"
