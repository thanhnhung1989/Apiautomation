#Author: nhungttt
@ToolsApi
Feature: Tool Api Testing

  @HappyCase
  Scenario: Check response when send request successfully
    Given I have url and method
    When I send tool request
    Then Status code is returned as 200
    Then Response body is correctly
    @HappyCase
Scenario: Check response when send request successfully with a specific category
    Given I have url and method
    When I send tool request with param "<category>"
    Then Status code is returned as 200
    And Response body matches category "<category>"
    Examples:
      | category            |
      | ladders             |
      | plumbing            |
      | power-tools         |
      | trailers            |
      | electric-generators |
      | lawn-care           |
    
     #@HappyCase
  #Scenario Outline: Check response when send request successfully with a specific category
    #Given I have url and method
    #When I send tool request with category <category> and results <results>
    #When I send tool request with category ladders and results 3
    #Then Status code is returned as 200
    #And Response body matches category <category> and results <results>
    #And Response body matches category ladders and results 3
    #
    #
     #Examples:
      #| category            |results|
      #| ladders             |3      |
      #| plumbing            |3			|
      #| power-tools         |1			|
      #| trailers            |1			|
      #| electric-generators |1			|
      #| lawn-care           |1			|

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