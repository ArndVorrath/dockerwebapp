Feature: Check if "Hello World" is visible on the page

  Scenario: Verify "Hello World" visibility on the page
    Given I am on the page "http://localhost:49160/"
    Then I should see the text "Hello World" on the page
