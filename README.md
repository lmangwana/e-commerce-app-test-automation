"# e-commerce-app-test-automation"

This project automates the checkout process for an e-commerce application.

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

BasePage is a base class that provides common functionality for all Page Object Model (POM) classes. It initialises the WebDriver instance and provides methods to get the WebDriver instance and the URL for the application. The WebDriver instance used by this class is determined by the config.properties file. The URL for the application is also obtained from the config.properties file. This class contains methods to get the WebDriver instance and the URL. It also contains utility  methods that can be used to generate random test data and perform common setup tasks. 

#### package pageObjects

- CheckoutPage
- HomePage
- ProductDetailsPage
- ShoppingCartPage

### package resources

- config.properties

Sure, here’s the formatted version of the section you provided:

### src/test/java

#### package testCases

- TC001: This is an end-to-end test case for an e-commerce application.
  The test case, TC001, extends the BasePage class and tests the checkout process of the application.

  Here’s a high-level description of the test:

  - **Setup (@BeforeMethod)**: The setup method initializes the WebDriver instance and navigates to the application URL.

  - **Test (@Test)**: The test method, checkoutTest(), performs the following steps:
    1. Selects a product named “T-Shirt” from the home page.
    2. Selects a size for the product on the product details page and adds the product to the cart.
    3. Proceeds to checkout from the product details page.
    4. Adds a promotional code on the shopping cart page and proceeds to checkout.
    5. Enters personal information (randomly generated) on the checkout page.
    6. Enters address information (randomly generated) on the checkout page.
    7. Enters a shipping method on the checkout page.
    8. Selects a payment method on the checkout page.
    9. Verifies the order confirmation message on the checkout page.
    10. Takes a screenshot of the current state of the application.

  - **Teardown (@AfterMethod)**: The teardown method closes the browser after the test is completed.
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

