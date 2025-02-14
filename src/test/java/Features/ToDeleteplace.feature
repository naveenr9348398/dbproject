@Deleteplace
Feature: User needs to validate the functionality of Delete place API
Scenario: User needs to verify the working functionality of deleteplace api
Given User needs to use the deleteplace Payload
When Userrr needs to use the "Deleteplaceapi" using http "delete" method
Then Userrr needs to validate if response status code is 200
And Userrr needs to validate and verify if "status" is "OK"