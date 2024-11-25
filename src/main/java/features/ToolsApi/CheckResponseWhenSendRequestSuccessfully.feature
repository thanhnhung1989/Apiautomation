#Author: nhungttt
@ToolsApi
Feature: Tool Api Testing

  @HappyCase
  Scenario: Check response when send request successfully
    Given I have url and method
      | URL                                              | Method |
      | /tools?category=ladders&results=2&available=true | GET    |
    When I send tool request
    Then Response return status code and body successfully
    Then Response body is correctly
      #@HappyCase
  #Scenario: Check response when send request successfully
    #Given I have <URL> and <Method>
    #When I send tool request with param <Category> and <results> and <available>
    #Then Status code is returned as 200
    #Then Response body is correctly
    #
    #Examples:
    #|URL|Method|Category|results|available
    #|https://simple-tool-rental-api.glitch.me/tools|GET|ladders|2|true|
