@Regression
Feature: User needs to validate the functionality of Addplace API
Scenario: User needs to verify the working functionality of Addplace API
Given User needs to add the Addplace Payload with "<lat>" "<lng>" "<accuracy>" "<name>" "<phonenumber>" "<address>" "<types1>" "<types2>" "<website>" "<language>"
When User needs to use the "Addplaceapi" using http "post" method
Then User needs to validate if response status code is 200
And User needs to verify the response of "status" is "OK"
And User needs to verify the response of "scope" is "APP"   
Examples:
|lat    |lng    |accuracy|name      |phonenumber    |address          |types1  |types2   |website                 |language   |
|90.4859|67.5858|90      |Alex house|(+91)484848949 |fin hen ten house|glen    |wen      |https://www.amazzonn.com|German     | 
