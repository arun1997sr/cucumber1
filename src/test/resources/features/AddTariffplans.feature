#Author: Arunsr.arunsrkumsr@your.domain.com
Feature: Add Tariff Plans validation

  Background: 
    Given user launchs demo telecome application
    And click on add tariff plans option

  @tag1
  Scenario: Add Tariff Plans
    When user enter all the requirements
    And user click submit button
    Then validate  you add Tariff Plan

  @tag1
  Scenario: Add Tariff Plans by using 1d list
    When user enter all the requirements by using one dimension list
      | 450 | 350 | 250 | 100 | 10 | 07 | 05 |
    And user click submit button
    Then validate  you add Tariff Plan

  @tag1
  Scenario: Add Tariff Plans by 1d map
    When user enter all the requirements by using one dimensional map
      | ren        | 450 |
      | loc min    | 400 |
      | intern min | 300 |
      | sms pack   | 200 |
      | loc chg    |  80 |
      | int chg    |  70 |
      | sms cgh    |  60 |
    And user click submit button
    Then validate  you add Tariff Plan
