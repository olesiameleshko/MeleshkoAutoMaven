Feature: Login

  Scenario: Login to Juice Shop
    Given User goes to login page
    When User enters email "omeleshko60@gmail.com" and password "22334455Le+"
    And User clicks on login button
    Then User "omeleshko60@gmail.com" should be logged to application