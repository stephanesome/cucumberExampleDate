Feature: Next date for valid date
  Next date should respond a valid date for a valid input

  Scenario Outline: The day after a valid date is a valid date
    Given the valid date <date> 
    When I ask for the next date
    Then the response should be <nextDate>
    
  Examples:
    | date               | nextDate             |
    | "1980/December/15" | "1980/December/16"   |
    | "2000/February/28" | "2000/February/29"   |
    | "1600/February/29" | "1600/March/1"       |
    | "1977/December/31" | "1978/January/1"     |
    | "25/February/28"   | "25/March/1"         |