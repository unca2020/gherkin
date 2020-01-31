# Automation priority: null
# Automation status: TRANSMITTED
# Test case importance: LOW
Feature: Access to the web page

  Scenario: Access from google
    Given I am on the google web page
    When I look for Unca
    And click on the result
    Then I am on the page of Unca
