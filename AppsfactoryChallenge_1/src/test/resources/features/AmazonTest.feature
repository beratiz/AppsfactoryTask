#Challenge 1:
#Set Up a Web Testing Project for Chrome that executes the following Test Case.
#
#As a new Amazon user, I want to search for the cheapest Snickers and Skittles on the page.
#
#Add the cheapest ones to your Basket and check if the basket calculates the result correctly
#
#Check if on Checkout, without an account, the user gets redirected to the registration page.
#
#Additional conditions:
#
#Document your project so a customer can use it without a personal ramp-up. (Readme.md)
#To formulate the Test Case, please use a descriptive Language that can be exported for automated Test Reporting. (preferred: “Cucumber”)
#Please write the Test as generic as possible to expand the Testsuite using the DRY-Principle.
#Multiple OS Drivers should be included (Windows, Linux MacOS)

@smoke
Feature: Setting up a WebApp project that executes the following features of Amazon website
  Searching a product and verifying the basket and checkout

  # Created a Background for the possible additional scenarios
  Background:
    Given As a new Amazon user, I am on the Amazon home page

  Scenario: Set Up a Web Testing Project for Chrome that executes the following Test Case
    Given I search products and add the cheapest one to Einkaufswagen
      | Snickers |
      | Skittles |
    And I navigate to Einkaufswagen
    Then verify that basket calculates the result correctly
    And I navigate to checkout
    Then verify that user gets redirected to registration page
