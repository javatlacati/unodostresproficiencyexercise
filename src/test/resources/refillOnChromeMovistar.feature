# Created by Ruslan López Carro at 18/08/2019
Feature: Automation Engineer Proficiency Exercise
  #The purpose of this exercise is to assess the candidate automation developer’s technical proficiency,
  #coding knowledge and style. The exercise involves building a basic automation framework for web application.
  #The exercise will be evaluated on coding style, understanding of programming concepts, choice of techniques and
  # quality of the final product.

  Scenario: Basic on Chrome
    Given I open the broser 'Chrome'
    Then I go to home page
    Then  under recarga celluar select operator as 'Movistar' from operador field
    And Give this number 6623003032 under numero de celluar field
    And under  monte de recharga select 10 dollar normal recharge
    And click on siguiente
    Then Verify if the user able to reach to the next screen or not(Payment screen)
    Then On payment screen click on tarjeta
    Then enter the following details
      | card name | Card number      | month | date | cvv | correo electronico |
      | Test      | 4111111111111111 | 11    | 2025 | 111 | test@test.com      |

    Then Click on pagar con tarjeta to do the recharge
    And verify if the recharge is success or not


