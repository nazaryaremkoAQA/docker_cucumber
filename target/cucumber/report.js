$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BuyProductFlow.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# new feature"
    },
    {
      "line": 2,
      "value": "# Tags: optional"
    }
  ],
  "line": 4,
  "name": "A description",
  "description": "",
  "id": "a-description",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2283458300,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Buy the dress flow",
  "description": "",
  "id": "a-description;buy-the-dress-flow",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I access yourlogo website",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I sign in to the website",
  "rows": [
    {
      "cells": [
        "ynazar123@gmail.com",
        "121212"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I click on t-shirt",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click on add to card",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on proceed to checkout in bucket block",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click on proceed to checkout in summary block",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click on proceed to checkout in address block",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I agree with term of service",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I click on proceed to checkout in shipping block",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I choose pay by bank wire",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I confirm my order",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I check if price is \"$19.25\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BuyProductFlowSteps.i_access_yourlogo_website()"
});
formatter.result({
  "duration": 6189169600,
  "status": "passed"
});
formatter.match({
  "location": "BuyProductFlowSteps.i_sign_in_to_the_website(DataTable)"
});
