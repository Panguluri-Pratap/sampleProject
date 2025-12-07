Feature: Alerts Frames and Windows

  @browseWindows
  Scenario: Browser Windows
    Given I launch the browser window application
    When I click on New Tab
    And I click on New Window
    Then I click on New Window Message

    @alert
    Scenario Outline: Alerts
      Given I launch the alerts page
      When i click on first alert
      And i click on second alert
      And i click on third alert
      Then i click on fourth alert "<name>"

      Examples:
        | name  |
        | hello |

      @frame
      Scenario: Frames
        Given I launch the frame page
        When i click on selenium tutorial link iframe1 and close the selenium page1
        Then i click on selenium tutorial link iframe2 and close the selenium page2
