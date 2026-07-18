# Advanced E-Commerce Automation Framework

A comprehensive and professional test automation framework designed for e-commerce web applications using **Java**, **Selenium WebDriver**, and **TestNG**. Built with an advanced architectural design to ensure test stability, data separation, and seamless error tracking.

---

## Technical Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Reporting Tool:** Extent Reports

---

## Architectural Features

### 1. Automated Screenshots on Failure
An intelligent system integrated within the test lifecycle (`@AfterMethod`). Upon detecting any assertion failure or unexpected error, the framework automatically captures a precise screenshot in `.png` format and stores it in the `screenshots/` directory for efficient debugging.

### 2. Data-Driven Testing (DDT)
Complete separation between test logic and test data. Leveraging TestNG's `@DataProvider`, the framework executes the same test scenario sequentially across multiple user accounts and datasets, significantly expanding test coverage without code duplication.

### 3. Flaky Test Mitigation via JavaScript
To handle random Google popups and transparent ad overlays on the target website, the framework injects custom JavaScript code. This code dynamically clears the screen and removes ad `iframes` before critical click actions, preventing `ElementClickInterceptedException` and ensuring continuous execution.

### 4. Interactive Performance Reports (Extent Reports)
Generates interactive HTML web reports featuring graphical dashboards and statistics that summarize test execution status (Pass/Fail). Error screenshots are embedded directly inside the report logs to simplify debugging.

---

## Test Lifecycle Structure

* **`@BeforeSuite`**: Initializes and configures the interactive Extent Reports HTML file.
* **`@BeforeMethod`**: Launches a clean Chrome browser instance, creates a new test log entry, and maximizes the window.
* **`@AfterMethod`**: Analyzes test results, captures screenshots on failure, appends logs, and terminates the browser session (`driver.quit()`).
* **`@AfterSuite`**: Finalizes, saves the execution report, and flushes the report stream (`extent.flush()`).

---

## Execution Guide
1. Clone the repository to your local machine.
2. Ensure all dependencies are downloaded via Maven.
3. Run the `testng.xml` suite or execute individual tests directly from your IDE.
4. Open the `test-output/` directory to view the generated HTML execution report.
