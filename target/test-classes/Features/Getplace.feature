@Regression
Feature: User needs to validate the functionality of Getplace API
Scenario: User needs to validate the functionality of Getplaceapi
Given User needs to use the Getplace payload
When Userr needs to use the "Getplaceapi" using http "get" method
Then Userr needs to validate if respons status code is 200
And Userr needs to verify if response of "types" is "glen,wen"
And Userr needs to verify if response of "address" is "fin hen ten house"
 