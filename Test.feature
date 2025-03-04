Feature: User Authentication
  As a user, I want to Sign Up, Sign In, and Sign Out so that I can access my account securely

  Scenario: Successful Sign Up
    Given the user is on the Sign-Up page
    When the user enters a valid email and a strong password
    And clicks the Sign-Up button
    Then the user should see a confirmation message
    And receive an email verification link

  Scenario: Sign Up with an already registered email
    Given the user is on the Sign-Up page
    When the user enters an already registered email and a password
    And clicks the Sign-Up button
    Then the user should see an error message "Email already exists"

  Scenario: Sign Up with an invalid email format
    Given the user is on the Sign-Up page
    When the user enters an invalid email format and a password
    And clicks the Sign-Up button
    Then the user should see an error message "Invalid email format"

  Scenario: Successful Sign In
    Given the user is on the Sign-In page
    When the user enters a valid email and password
    And clicks the Sign-In button
    Then the user should be redirected to the dashboard

  Scenario: Sign In with incorrect password
    Given the user is on the Sign-In page
    When the user enters a valid email and an incorrect password
    And clicks the Sign-In button
    Then the user should see an error message "Incorrect password"

  Scenario: Sign In with an unregistered email
    Given the user is on the Sign-In page
    When the user enters an unregistered email and any password
    And clicks the Sign-In button
    Then the user should see an error message "User does not exist"

  Scenario: Successful Sign Out
    Given the user is logged in
    When the user clicks the Sign-Out button
    Then the user should be redirected to the Sign-In page
    And should not be able to access the dashboard without logging in again