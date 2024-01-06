Feature: Extract React JS Documentation

  Scenario: Extract sub-elements from Concepts and Advanced Guides Tabs
    Given I navigate to React JS site
    When I click on Docs Tab
    Then I extract and save Concepts sub-elements in a file
    And I extract and save Advanced Guides sub-elements in a file

  