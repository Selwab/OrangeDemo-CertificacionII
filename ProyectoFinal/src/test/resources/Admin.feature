Feature: Admin Orange Demo Page
  Background: Get to home page to click on Admin
    Given I am in orange demo web page
    And I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button
    And I click on the Admin button


  @AddLocation
  Scenario: Add new location
    Given I click on the Admin button
    And I click on the Organization button
    And I click on the Add button admin
    And I fill the new location information with the following data
      | Cbba-Bol | Bolivia |
    And I click on the Save button admin
    And I verify location by "Cbba-Bol" in the list admin
    Then I logout to orange demo page

