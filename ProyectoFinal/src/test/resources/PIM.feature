Feature: PIM Orange Demo Page
  Background: Get to home page to click on PIM
    Given I am in orange demo web page
    And I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button

    @AddEmployee
    Scenario Outline: Add new employee
      Given I click on the PIM button
      And I click on the Add button
      And I fill the new employee information with the following data
        | <First_Name> | <Last_Name> |
      And I click on the Save button
      Then I click on Employee List button
      And I verify employee by "<First_Name>" in the list
      Then I logout to orange demo page

      Examples:
        | First_Name | Last_Name |
        | Harry      | Styles    |
        | Jennifer   | Aniston   |
        | Leonardo   | DiCaprio  |
        | Justin     | Bieber    |

  @DeleteEmployee
  Scenario Outline: Delete employee
    Given I click on the PIM button
    Given I verify employee by "<First_Name>" in the list
    Then I click delete button
    And I verify employee "<First_Name>" was deleted correctly
    Then I logout to orange demo page

    Examples:
      | First_Name |
      | Harry      |
      | Jennifer   |
      | Leonardo   |
      | Justin     |

