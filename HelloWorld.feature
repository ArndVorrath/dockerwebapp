Feature: Verify "Hello World" on the page
  Scenario: Check if "Hello World" is visible on page "localhost:49160/"
    Given I open the URL "http://localhost:49160/"
    Then I should see the text "Hello World"
