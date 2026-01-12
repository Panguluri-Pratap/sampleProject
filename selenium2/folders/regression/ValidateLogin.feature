Feature: To validate login functionality in web

  Scenario: To validate login using valid credentials
    Given user starts "chrome" browser
    And user launch app using url "https://adactinhotelapp.com/"
    When user enters username "reyaz0806" in textbox using xpath "//input[@name='username']"
    And  user enters password "reyaz123" in textbox using xpath "//input[@name='password']"
    And user clicks login or submit button using xpath "//input[@name='login']"
    Then user validates title to be "Adactin.com - Search Hotel"