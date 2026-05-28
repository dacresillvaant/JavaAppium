# JavaAppium - Android Mobile Test Automation Framework

A test automation framework for Android mobile applications built with **Java**, **Appium**, and **TestNG**.

## 🎯 Purpose

This project demonstrates a test automation framework showcasing best practices for mobile testing with Appium on Android devices/emulators.

## 🛠️ Tech Stack

- **Java 21** - Programming language
- **Appium 10.1.1** - Mobile automation tool
- **TestNG 7.12.0** - Testing framework
- **Maven 3** - Build tool
- **Logback** - Logging framework
- **Allure Reports** - Test reporting
- **Lombok** - Code generation library

## ✨ Key Features

- **Page Object Model (POM)** - Clean separation of test logic and page interactions
- **Thread-Safe Driver Management** - Support for multiple device configurations
- **Intelligent Wait Strategies** - Explicit waits with custom conditions
- **Soft & Hard Assertions** - Flexible test validation
- **Test Listeners** - Custom test lifecycle hooks (setup, teardown, reporting)
- **Retry Analyzer** - Automatic flaky test retry logic
- **Structured Logging** - Comprehensive test execution logs
- **Allure Integration** - Rich HTML test reports with screenshots and attachments
- **Maven Suite Files** - Flexible test grouping and execution

## 📁 Project Structure

```
JavaAppium/
├── src/
│   ├── main/
│   │   └── java/com/dacresillvaant/appium/
│   │       ├── base/          # BasePage, BaseTest abstractions
│   │       ├── driver/        # DriverFactory, driver configuration
│   │       ├── pages/         # Page Object classes
│   │       ├── listeners/     # TestNG listeners
│   │       ├── retryanalyzer/ # Retry logic
│   │       └── utils/         # Utilities (wait strategies, helpers)
│   └── test/
│       ├── java/com/dacresillvaant/appium/tests/  # Test classes
│       └── resources/                              # Test configs, suite files
├── pom.xml
└── allure-results/  # Allure test reports
```

## 🚀 Getting Started

### Prerequisites
- Java 21+
- Maven 3.6+
- Android Emulator or connected Android device
- Appium Server running

### Run Tests

```bash
# Run default suite (all tests)
mvn clean test

# Run specific suite
mvn clean test -Dsuite.file=src/test/resources/suitefiles/login_test_suite.xml

# Generate Allure report
mvn allure:report
```

## 📊 Test Coverage

- **Product Catalog Tests** - Browse, search, filter products
- **Product Details Tests** - View details, specifications, reviews
- **Cart Management Tests** - Add/remove items, quantity updates, checkout flow
- **Authentication Tests** - Login, logout, session management

## 📚 Learn More

Detailed documentation and advanced configurations coming soon.

---

*A portfolio project showcasing mobile test automation expertise.*  
*This readme was AI-generated for demonstration purposes - I'm going to improve it later, once I have finished all the functionalities.*

