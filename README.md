# E-commerce Application Test Automation

This project is a test automation of a checkout process for an e-commerce application.

## Technologies Used

- Selenium
- Java
- Maven
- TestNG

## Design Pattern

Page Object Model (POM)

## Project Structure

### src/main/java

#### package base

BasePage is a base class that provides common functionality for all Page Object Model (POM) classes. It initialises the WebDriver instance and provides methods to get the WebDriver instance and the URL for the application. The WebDriver instance used by this class is determined by the config.properties file. The URL for the application is also obtained from the config.properties file. This class contains methods to get the WebDriver instance and the URL. The WebDriver instance and the URL are used by all POM classes that extend this class.

#### package pageObjects

- CheckoutPage
- HomePage
- ProductDetailsPage
- ShoppingCartPage

### package resources

- Listeners
- config.properties

### src/test/java

#### package testCases

- TC001: This is our end-to-end test which has checkOutTest()
- TC002: This is our AddRemoveItemBasketTest
  1. Add white, medium hummingbird tshirt , quantity 2 to basket
  2. Proceed to continue shopping
  3. Add sweater, small, quantity 1
  4. Proceed to checkout
  5. Remove sweater from checkout
  6. Verify the total amount is actually $45.24 with an assertion

## Getting Started

### Dependencies

- Java
- Selenium WebDriver
- Maven
- TestNG

### Installing

1. Clone the repo: `git clone https://github.com/lmangwana/e-commerce-app-test-automation`
2. Navigate to the project directory: `cd repo`
3. Install dependencies: `mvn install`

### Executing program

Run the program using `mvn test`

## Authors

LuthoMangwana

