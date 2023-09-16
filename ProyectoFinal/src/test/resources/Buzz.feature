Feature: Buzz Orange Demo Page
  Background: Get to home page to click on Buzz
    Given I am in orange demo web page
    And I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button

    @AddPost
    Scenario: Add new post
      Given I click on the Buzz button
      And I fill the text area with "Try do my first Post!"
      And I click on the post button
      Then I verify if the "Try do my first Post!" post uploded correctly
      Then I logout to orange demo page