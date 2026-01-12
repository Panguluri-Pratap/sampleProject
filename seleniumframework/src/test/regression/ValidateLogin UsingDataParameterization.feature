Feature: To validate login functionality in web

  Scenario Outline: To validate login using valid credentials
    Given user starts "chrome" browser
    And user launch app using url "https://adactinhotelapp.com/"
    When user enters <username> in textbox using xpath "//input[@name='username']"
    And  user enters <password> in textbox using xpath "//input[@name='password']"
    And user clicks login or submit button using xpath "//input[@name='login']"
    Then user validates title to be <expTitle>

    Examples:

    |username|password|expTitle|
    |reyaz0806|reyaz123|Adactin.com - Search Hotel |
    |reyaz0123|reyaz143|Adactin.com - Hotel Reservation System |
    |reyaz1562|reyaz193|Adactin.com - Hotel Reservation System |
    |reyaz0293|reyaz983|Adactin.com - Hotel Reservation System |