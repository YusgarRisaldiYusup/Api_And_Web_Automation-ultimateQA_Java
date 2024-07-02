Feature: Test Automation Api

  @api
  Scenario: Get all users list
    Given preapre url for "GET_ALL_LIST"
    And hit api for get list users
    And verify status code 200
    Then verify response body for get all users
    And verify with json schema "GET_ALL_LIST_USERS.json"

    @api
  Scenario: Get spesific user
    Given preapre url for "GET_SPESIFIC_USER"
    And hit api for get spesific user id 7
    And verify status code 200
    Then verify response body for get spesific user
    And verify with json schema "GET_SPESIFIC_USER.json"

    @api
  Scenario: Delete spesific user
    Given preapre url for "DELETE_USER"
    And hit api for delete spesific user id 8
    And verify status code 204

   @api
  Scenario: create new user
    Given preapre url for "CREATE_USER"
    And hit api for create new user
    And verify status code 201
    Then verify response body for create user

