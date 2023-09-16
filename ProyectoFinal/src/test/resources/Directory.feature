Feature: PIM Orange Demo Page
  Background: Get to home page to click on PIM
    Given I am in orange demo web page
    And I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button
    And I click on the Directory button

