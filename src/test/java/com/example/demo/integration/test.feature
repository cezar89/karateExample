Feature: test feature

Scenario: Testing valid GET endpoint
  Given url 'http://localhost:8080/show'
  When method GET
  Then status 200
  And match response == {response: 'hello world'}
