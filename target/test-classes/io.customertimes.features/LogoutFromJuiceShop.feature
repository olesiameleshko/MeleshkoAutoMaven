Feature: Logout

  Scenario Outline: Logout from Juice Shop
    Given User logged in to the app using "<email>" and "<password>"
    When User logged out
    Then The user should be logged out from Juice Shop

    Examples:

      |email                |password   |
      |omeleshko60@gmail.com|22334455Le+|