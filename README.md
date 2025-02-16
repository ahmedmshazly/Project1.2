
# Pizza Configuration API - Project 1.2

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture & Design](#architecture--design)
  - [Model Package](#model-package)
  - [Wrapper Package (API)](#wrapper-package-api)
  - [Exceptions Package](#exceptions-package)
  - [File I/O Module](#file-io-module)
  - [Multithreading & Synchronization](#multithreading--synchronization)
- [File Structure](#file-structure)
- [Installation & Setup](#installation--setup)
- [Usage](#usage)
  - [Running the API](#running-the-api)
  - [File I/O Test](#file-io-test)
  - [Multithreading Test](#multithreading-test)
- [Testing](#testing)
- [Design Artifacts](#design-artifacts)
- [Future Enhancements](#future-enhancements)
- [Credits & License](#credits--license)

## Overview
Project 1.2 builds on Projects 1.0 and 1.1 by integrating file input/output (I/O) and multithreading support into the Pizza Configuration API. This iteration focuses on:
- Reading a pizzeria configuration from a flat file in a single pass.
- Simulating concurrent modifications to the pizzeria configuration via multithreading.
- Adding synchronization to prevent data corruption during concurrent updates.

## Features
- **Dynamic Data Structures:**  
  The model uses `ArrayList` for flexible management of OptionSets and Options.
- **API Layer:**  
  The `wrapper` package exposes a controlled set of methods for managing pizzeria configurations.
- **File I/O Integration:**  
  The `io` package includes a `PizzaConfigBuilder` that reads a flat file and constructs a `PizzaConfig` object.
- **Multithreading & Synchronization:**  
  The `scaletests` package simulates multiple users (via the `SimulatedUser` class) accessing the API concurrently. Critical API methods are synchronized to ensure thread safety.
- **Custom Exception Framework:**  
  A basic custom exception hierarchy (in the `exceptions` package) lays the foundation for robust error handling.
- **Comprehensive Testing:**  
  Test drivers in the `driver` package demonstrate file I/O and multithreading functionality.

## Architecture & Design

### Model Package
- **PizzaConfig:**  
  Represents a complete pizza configuration, with a name, base price, and a list of OptionSets.
- **OptionSet:**  
  Represents a group of options (e.g., sizes, toppings). Contains an inner class **Option** that stores option details.

### Wrapper Package (API)
- **Interfaces:**  
  - `CreatePizzeria`: Methods for creating and configuring pizzerias.
  - `UpdatePizzeria`: Methods for updating configuration details.
- **Abstract Class:**  
  - `ProxyPizzerias`: Maintains a static shared `LinkedHashMap` of pizzerias.
- **Concrete Class:**  
  - `PizzeriaConfigAPI`: Implements API methods with proper synchronization for thread safety.

### Exceptions Package
- **Custom Exceptions:**  
  Contains `PizzeriaException` (base class), `MissingBasePriceException`, `DuplicateOptionSetException`, etc.
- **ExceptionFactory:**  
  Provides a standard way to create custom exceptions.

### File I/O Module
- **PizzaConfigBuilder:**  
  Located in the `io` package, this class reads a flat file (one-pass) using `BufferedReader` and creates a `PizzaConfig` object from the file contents.
- **Flat-File Format:**  
  The file uses markers like:

````
- Pizzeria: Pizza Palace
- BasePrice: 1600.0
- PizzaConfig: Deluxe Pizza
- OptionSet: Size
- Option: Small,0.0
- Option: Medium,250.0
- Option: Large,500.0
- OptionSet: Toppings
- Option: Pepperoni,200.0
- Option: Mushrooms,150.0
- Option: Onions,100.0
````  

### Multithreading & Synchronization
- **SimulatedUser:**  
  In the `scaletests` package, simulates a user by performing API operations in its own thread.
- **Test Drivers:**  
  `MultiUserTestDriver` launches multiple `SimulatedUser` threads concurrently to update a single pizzeria configuration.
- **Synchronization:**  
  Critical methods in `PizzeriaConfigAPI` are synchronized to prevent data corruption during concurrent modifications.

## File Structure
```
Project1.2/
├── src/
│   ├── model/
│   │   ├── PizzaConfig.java
│   │   └── OptionSet.java
│   ├── wrapper/
│   │   ├── CreatePizzeria.java
│   │   ├── UpdatePizzeria.java
│   │   ├── ProxyPizzerias.java
│   │   └── PizzeriaConfigAPI.java
│   ├── exceptions/
│   │   ├── PizzeriaException.java
│   │   ├── MissingBasePriceException.java
│   │   ├── DuplicateOptionSetException.java
│   │   └── ExceptionFactory.java
│   ├── io/
│   │   └── PizzaConfigBuilder.java
│   ├── scaletests/
│   │   └── SimulatedUser.java
│   └── driver/
│       ├── PizzeriaAPITestDriver.java
│       ├── MultiUserTestDriver.java
│       └── FileIOTestDriver.java
├── README.md
├── uml_diagram.png 
├── PizzaTestAPI.txt
├── config.txt
├── .gitignore
└── build.xml / pom.xml / build.gradle
```

## Installation & Setup

### Prerequisites
- Java JDK 8 or higher
- IntelliJ IDEA Ultimate (or your preferred IDE)
- Git (for version control)
- Maven/Gradle/Ant (depending on your build tool)

### Steps
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/ahmdmshazly/Project1.2.git
   cd Project1.2
   ```
2. **Open in IntelliJ IDEA:**
    - Select **File > Open...** and navigate to the project directory.
3. **Build the Project:**
    - Use IntelliJ's **Build > Build Project** or run your build tool command (e.g., `mvn clean install`).

## Usage

### Running the API
- **API Test Driver:**  
  Run `PizzeriaAPITestDriver` from the `driver` package to test API operations from Project 1.1.

### File I/O Test
- **FileIOTestDriver:**  
  Ensure a configuration file (e.g., `config.txt`) exists with the correct format, then run `FileIOTestDriver` to configure a pizzeria from file and print the configuration.

### Multithreading Test
- **MultiUserTestDriver:**  
  Run this driver to simulate concurrent user modifications and observe the effects of synchronization.

## Testing
- **JUnit Tests:**  
  Existing tests from Project 1.1 (in the `test` package) are maintained to verify core model functionality.
- **Integration Testing:**  
  Use the provided test drivers to verify file I/O and multithreading behavior.

## Design Artifacts
- **UML Diagram:**  
  ![UML Diagram](uml_diagram.jpg)
  See `uml_diagram.jpg` for the complete system architecture, including new modules for file I/O and multithreading.
- **Design Rationale Document:**  
  (Optional) Include detailed explanations of design choices, challenges, and lessons learned during Project 1.2.

## Future Enhancements
- **Advanced Custom Exception Integration:**  
  Fully integrate and expand the custom exception framework.
- **Enhanced File I/O:**  
  Improve file parsing logic and support additional file formats.
- **Robust Multi-threading:**  
  Explore more advanced concurrency utilities (e.g., ExecutorService, ReentrantLock).
- **UI Integration:**  
  Develop a user interface for interactive pizzeria configuration.

## Credits & License
- **Developed by:** AHMED MOHAMED - A GRADUATE STUDENT WITH MIDDLE INTELLIGENT CAPABILITIES WHO IS ABOUT TO LOSE HIS MIND WRITING THIS HIEROGLYPHIC CODE.  
- **Course:** DPSD (Design Patterns For Smartphone Development)
- **Institution:** CMU-AFRICA, our sugar momy
- **License:** This project is licensed under the [MIT License](LICENSE).
