Feature: Text Box

  @Test
  Scenario Outline: Submit multiple test data for Text Box
    Given I launch the Text Box application
    When I enter full name "<FullName>"
    And I enter email "<Email>"
    And I enter current address "<CurrentAddress>"
    And I enter password "<Password>"
    And I click on submit button
    Then I should see the submitted details displayed correctly

    Examples:
      | FullName   | Email                  | CurrentAddress   | Password     |
      | John Doe   | john@example.com       | Chennai, India   | Test@123     |
      | Amit Singh | amit.singh@example.com | Bangalore, India | Password@123 |


    @Test1
    Scenario: Click on mutliple checkboxs
      Given I launch the Check box application
      Then Clicked on Checkbox one
      And Clicked on plus symbol for one
      Then Clicked on Checkbox two
      And Clicked on plus symbol for two


  @Hello
  Scenario Outline:Click on Radio Multiple Buttons
        Given I launch the Radio button application
        When Clicked on Yes Radio button
        Then I should see the Yes Radio btn message "<string1>"
        When I clicked on Impressive Radio button
        Then I should see the Impressive Radio btn message "<string2>"
        Then Validated No radio button is disabled

        Examples:
          | string1              | string2          |
          | You have checked Yes | You have checked Impressive|
