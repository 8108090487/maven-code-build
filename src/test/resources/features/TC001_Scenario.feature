Feature: Google Search

  Scenario: Test Google search functionality
    Given I am on the Google homepage
    When I search for "Cucumber testing"
    Then the results page should show results