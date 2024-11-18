#Author: nhungttt
@ToolsApi
Feature: Tool Api Testing

  @HappyCase
  Scenario: Check response when send request successfully
    Given I have url and method
    When I send tool request
    Then Status code is returned as 200
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