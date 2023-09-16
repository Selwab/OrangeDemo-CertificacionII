Feature: Login Orange Demo App
  Background: User login into Orange Demo
    Given I am in orange demo web page

    @loginWithValidCredentials
    Scenario: Login into Orange Demo page with valid credentials
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      When I click on the login button
      Then The home page should be displayed
      Then I logout to orange demo page