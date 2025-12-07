# Feature:User Login
  # Background: User navigates to login page
  # Scenario: Valid Login
  # Scenario Outline: Login with Multiple users

  # Step Definition Keywords : Given, When, Then, And, But

  # Tags:  @Smoke, @Regression, @HighPriority, @Login

  # Hello, Hello@143   https://para.testar.org/parabank/about.htm;jsessionid=FB240F858FA900BA96DEE5A980656F85

  Feature: HomePage Application

    Scenario: Verify HomePage of the Application
      Given I navigate to the home page
      When Navigate to forgot password link
      Then I should see forgot password page