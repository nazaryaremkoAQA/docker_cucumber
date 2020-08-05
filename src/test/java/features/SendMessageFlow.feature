# new feature
# Tags: optional

Feature: A description

  Scenario: Send message flow
    Given I access yourlogo website
    And I click on contact us
    And I choose "Customer service" from subject heading
    And I enter email address
    And I enter message "I need help"
    And I press send button
    Then I see proper message "Your message has been successfully sent to our team."

  Scenario: Buy the dress flow
    Given I access yourlogo website
    When I sign in to the website
      |ynazar123@gmail.com|121212|
    And I click on t-shirt
    And I click on add to card
    And I click on proceed to checkout in bucket block
    And I click on proceed to checkout in summary block
    And I click on proceed to checkout in address block
    And I agree with term of service
    And I click on proceed to checkout in shipping block
    And I choose pay by bank wire
    And I confirm my order
    Then I check if price is "$19.25"