<img align="right" src="https://appsfactory.de/wp-content/themes/appsfactory-2_0/img/logo.svg">
<br>

# Challenge 1

## About Project
This project specificly is to do automation tests for any product search on the amazon website, verify the sum of basket and checkout. However you can extend basicly the framework for your UI or Backend Tests.
## About Framework
- Selenium is used as a suite of tools for automating web browsers.
- Cucumber is used as a tool that supports [Behaviour-Driven Development (BDD)](https://cucumber.io/blog/bdd/intro-to-bdd-and-tdd/) - a software development process that aims to enhance software quality and reduce maintenance costs.
  Cucumber executes executable specifications written in plain language and produces reports indicating whether the software behaves according to the specification or not.
- Java is the programming language to apply test scripts.
- Maven is used as the building management tool. It provides an easy way to manage dependencies in pom.xml file, which are necessery for the project.
- Page Factory and Singleton are used as design pattern.

### Framework Structure
### Packages
- pages
    - Consists of page classes to manage web elements and necessary actions. 
- runners
  - Consist of TestRunner class to define cucumber options and this class triggers the execution.
- stepdefinitions
    - Consist of step definition classes which are defined in gherkin language in feature files.
- utilities
    - Consist of;
        - ConfigReader class: To read variables from configuration.properties file.
        - Driver class: To manage Webdriver.
        - ReusableMethods class: To store common used, util methods.
### Features Folder
Test cases are written here in [gherkin language](https://cucumber.io/docs/gherkin/) which has an easily understandable syntax by everybody.  
    
## Platforms
Since WebDriverManager is used to create a chrome driver, it is possible that you can run the code on any operating systems (e.g. Windows, Linux, MacOS).

WebDriverManager supports an Automatic Selenium WebDriver binaries management in runtime for Java.


## Pre-requestes
You need to have these installations on your pc before to run the project and develop further;

- [Java JDK 11](https://www.oracle.com/de/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [IntelliJ IDEA (2020.3 or later)](https://www.jetbrains.com/idea/)
- [Cucumber for Java](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java) and [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin) plugins should be installed on IntelliJ IDEA
- [Chrome browser](https://www.google.com/chrome/)

Or, you can easily run the project using commond promt(terminal) having Java JDK 11 and Maven.

## How to clone the Project
After all the installations which are given under the title Pre-requestes, follow these steps to clone the project from GitHub to your local computer;

1. Open IntelliJ IDEA
2. Select
    * File -> New -> Project from Version Control
3. Copy the [code link](https://github.com/beratiz/testtask.git) from GitHub and paste to URL
4. Then click Clone

Or,

Just open terminal and use this;


> git clone https://github.com/beratiz/testtask.git


Now you have the codes and ready to run the test.

## Running test
### First way:
Go to your project directory from terminal and hit following command

> mvn clean verify

or

> mvn test
### Second way:
Run Test by using TestRunner class where is `/src/test/java/de/amazon/runners/TestRunner.java`
## Getting Report
You will find the report `/target/default-cucumber-reports/cucumber.html` and can open `cucumber.html` file with any browser and see the report of test execution. You will also see a screenshot for any failed steps.

Secondly, you will also get as a result of test execution a Cucumber Report link which you can see the test report on Cucumber Report Service.

Like;

>View your Cucumber Report at: <br>
`https://reports.cucumber.io/reports/47042ec2-7641-4b04-84b8-8d35cb35db1b`







