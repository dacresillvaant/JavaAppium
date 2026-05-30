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
- **Thread-Safe Driver Management** - Support for multiple device configurations via ThreadLocal
- **Parallel Test Execution** - Simultaneous testing on multiple Android devices/emulators
- **Intelligent Wait Strategies** - Explicit waits with custom conditions
- **Soft & Hard Assertions** - Flexible test validation
- **Test Listeners** - Custom test lifecycle hooks (setup, teardown, reporting)
- **Retry Analyzer** - Automatic flaky test retry logic
- **Structured Logging** - Comprehensive test execution logs with Logback
- **Allure Integration** - Rich HTML test reports with screenshots attached on failure
- **Maven Suite Files** - Flexible test grouping and execution via `-Dsuite.file` parameter

## 📁 Project Structure

```
| JavaAppium/
| ├── src/
| │   └── test/
| │       ├── java/com/dacresillvaant/appium/
| │       │   ├── driver/        # DriverFactory, driver configuration
| │       │   ├── pages/         # Page Object classes
| │       │   ├── listeners/     # TestNG listeners
| │       │   ├── retryanalyzer/ # Retry logic
| │       │   ├── dataproviders/ # TestNG data providers
| │       │   ├── utils/         # Utilities (wait strategies, helpers)
| │       │   └── tests/         # Test classes
| │       └── resources/         # Test configs, suite files, test application APK
| ├── target/
| │   ├── allure-results/   # Allure test results
| │   └── allure-report/    # Allure test report
| ├── pom.xml
| └── README.md
```

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Maven 3.6+
- Node.js
- Android Studio with at least one configured emulator

### Install Appium

```bash
npm install -g appium
appium driver install uiautomator2
```

### Start Appium Server

```bash
appium
```

### Start Android Emulator

Open Android Studio → Device Manager → start your emulator. Verify it is running:

```bash
adb devices
```

### Run Tests

```bash
# Run default suite (all tests)
mvn clean test

# Run specific suite
mvn clean test -Dsuite.file=src/test/resources/suitefiles/login_test_suite.xml

# Run parallel suite on two emulators
mvn clean test -Dsuite.file=src/test/resources/suitefiles/parallel_suite.xml

# Generate and open Allure report
mvn allure:serve
```

## 📊 Test Coverage

- **Authentication Tests** - Login, logout, session management, field validation
- **Product Catalog Tests** - Product list display, product count, names and prices
- **Product Detail Tests** - Product information, quantity management, navigation
- **Cart Tests** - Add/remove items, quantity updates, checkout button visibility

## ⚠️ Known Limitations

- Android only — iOS is not supported
- Requires local Android emulator or connected device
- Parallel execution requires two running emulators

---

*A portfolio project showcasing mobile test automation expertise.*