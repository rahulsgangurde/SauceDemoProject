
# Selenium Test Automation Framework

## Overview
This repository contains a Selenium-based test automation framework for testing https://www.saucedemo.com/v1/. The framework is built using Java, TestNG, and Selenium WebDriver. It provides a structured approach to automate test cases and generate test reports using ExtentReports.


## Components
The framework consists of the following components:

PageObjects: Contains classes representing web pages and their elements. 

TestCases: Includes test classes containing test methods.

TestComponent: Contains reusable components and configurations used across test cases. It includes the BaseTest class for test setup and teardown, Listners class for generating test reports, and other utility classes.

Resources: Contains configuration files and resources required for test execution, such as browser configuration properties and ExtentReports configuration.




## To Run
Clone the Repository: Clone this repository to your local machine using Git.

git clone https://github.com/rahulsgangurde/SauceDemoProject.git

Setup Environment: Ensure you have Java, Selenium WebDriver, TestNG, and the necessary browser drivers installed on your machine.

Configure Properties: Update the browser configuration and other properties in globalData.properties 

Run Tests: Execute test cases by running the test classes located in the TestCases package. You can run individual test classes or the entire test suite.

To run the test-

mvn test

## To View Reports:


 Test reports generated by ExtentReports can be found in the test-output directory. Open the HTML report to view detailed test results and screenshots.

![Annotation 2024-03-30 140925](https://github.com/rahulsgangurde/SauceDemoProject/assets/149608485/35007cc1-dcf3-4c92-b5fc-a250ea6a49c5)

![Annotation 2024-03-30 141421](https://github.com/rahulsgangurde/SauceDemoProject/assets/149608485/f625402b-9387-4fba-b0be-9e9f919145d7)


## Additional Notes-
DataProvider: Test data for parameterized tests is provided using TestNG's DataProvider annotation. You can update the data provider methods in test classes to supply different sets of test data.

ExtentReports: The framework utilizes ExtentReports for generating interactive and detailed HTML test reports. You can customize report configurations and styles as per your requirements.

Screenshot Capture: Screenshots are captured automatically for failed test cases and embedded in the test reports, providing visual evidence of test failures.

Test Listeners: TestNG Listeners are implemented for capturing test execution events and generating comprehensive test reports.
## Authors

- [Rahul Gangurde]()

