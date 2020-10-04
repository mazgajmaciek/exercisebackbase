# exercisebackbase - readme

To execute tests and produce test reporting:

1. make sure you have maven and allure binaries installed and added to PATH as environment variables
2. run 'mvn clean test'
3. allure test-results should be saved in root/allure-results folder
4. run 'allure serve allure-results'
5. test report should open in web browser
