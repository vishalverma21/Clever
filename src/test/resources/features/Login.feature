Feature: Login

  @vvvv
  Scenario: Validate connecting bluetooth device
    Given Go to CleverShuttle
    And Enter UserName and Password
    Then Click on Login button
    Then Verify Home Page
    And Click on working time
    Then Verify that user is redirected to working time area
    Then Click on Record working time
    And Validate that timer is started
    Then Click on stop working time
    And Validate that the timer is stopped