Feature: Login

  @web
  Scenario: Login with Valid user
    Given user in the logging page
    Then user input the valid email "yusjaryusuf@gmail.com"
    And user input valid password "yuyuyu90"
    And user click loggin button
    And user direct to homepage

    @web
  Scenario: Login with inValid user
    Given user in the logging page
    Then user input the invalid email "yusjaryusuf@wrongmail.com"
    And user input valid password "yuyuyu90"
    And user click loggin button
    And user will see the invalid massage

      @web
  Scenario: sign out from the homepage
    Given user in the logging page
    Then user input the valid email "yusjaryusuf@gmail.com"
    And user input valid password "yuyuyu90"
    And user click loggin button
    Then user click the account setting
    And user click logout text
    And user will direct out to logging page