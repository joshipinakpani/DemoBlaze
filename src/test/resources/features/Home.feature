Feature: Demo Blaze Website Sanity Test. As a tester
  I want to perform a sanity test on the Demo Blaze website, 
  So that I can ensure the website is functioning correctly before starting deeper functional testing

  # Scenario to verify the URL for Demo Blaze on Google browser
  Scenario: Verify the Demo Blaze website is accessible in the Google browser
    Given The user is on a web browser
    When The user navigates to "https://www.demoblaze.com/index.html"
    Then The homepage is displayed

  #Scenario to verify successful navigation to the sign-up page
  Scenario: Verify that the user is redirected to the sign-up page
    Given The user is on a web browser
    When The user navigates to "https://www.demoblaze.com/index.html"
    And The user clicks on the sign-up link
    Then Signup window contains all the fields

  Scenario: Signup on the portal
    Given The user is on a web browser
    When The user navigates to "https://www.demoblaze.com/index.html"
    And The user clicks on the sign-up link
    And user enters username as "Pinakpani"
    And user enters password as "pinakpani123"
    And click on signup button
    Then Sign up successful. message confirmation

  Scenario: User already exist
    Given The user is on a web browser
    When The user navigates to "https://www.demoblaze.com/index.html"
    And The user clicks on the sign-up link
    And user enters username as "pratikbhai"
    And user enters password as "pratikbhai123"
    And click on signup button
    Then This user already exist. message confirmation
