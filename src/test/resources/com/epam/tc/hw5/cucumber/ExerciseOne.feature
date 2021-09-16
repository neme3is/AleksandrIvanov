Feature: Checking functionality of elements on page with different elements

  Scenario: Checking correctness of logs for elements
    Given I open jdi-testing.com index page
    And I login the site
    And I open through the header menu Service -> Different Elements Page
    When I select Water and Wind checkboxes
    And I select Selen radiobutton
    And I select Yellow color in dropdown list
    Then There are correct log rows for marked checkboxes
    And There is correct log row for marked radiobutton
    And There is correct log row for chosen color in dropdown list