Feature: Translations

  Scenario: Juice Shop is translated
    Given User goes to Juice Shop
    When User change language preferences
    Then Juice Shop should be translated