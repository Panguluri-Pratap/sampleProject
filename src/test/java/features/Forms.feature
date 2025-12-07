Feature: Student Registration Form

  @StudentRegistration
  Scenario Outline: Successfully register a student
    Given I launch the Student Registration Form Application
    When I enter student name "<name>"
    And I enter student email "<email>"
    And I select student gender
    And I enter student mobile number "<mobile>"
    And I enter student subject "<subject>"
    And I select student hobbies
    And I upload student picture
    And I enter student address "<address>"
    And I select state and city
    Then I click on Submit button

    Examples:
      | name   | email         | mobile     | subject | address   |
      | Pratap | test@test.com | 9999999999 | Maths   | Hyderabad |

  @StudentRegister
  Scenario Outline: Student Register
    Given I launch the student register application
    When I enter the First Name "<FName>"
    And I enter the Last Name "<LName>"
    And I enter the User Name "<UName>"
    And I enter the Password "<Pswd>"
    And click on Register button
    Then click on back to login button

    Examples:
      | FName  | LName | UName | Pswd   |
      | Pratap | Kumar | buddy | ha@123 |

  @StudentLogin
  Scenario Outline: Student Login
      Given I launch the student login page
      When I enter emaail "<semail>"
      And I enter passwod "<spswd>"
      And click on login button
      Then click on new user button

    Examples:
      | semail          | spswd     |
      | hello@gmail.com | hello@123 |






