#Author: nhungttt
@SingleTool
Feature: SingleTool Api Testing

  @HappyCase
 Scenario: Check response when send request with toolID
    Given I have url and method test for single tool
    When I send tool request with param toolID "<toolID>"
    #Then Status code is returned test for single tool 200
    And Response body matches toolID "<toolID>"
    Examples:
    |toolID|
    |4643 |
    |1225 |
    |5499 |
    