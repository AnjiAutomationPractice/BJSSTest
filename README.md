## UI Test Automation

 This repository contains UI Automated tests for test website


# Installation

#### Dependencies : Maven, Rest Assured, Junit, TestNG, IntelliJIDEA and JAVA


# Usage

User can run the tests either from Command Line or using InelliJ

To Run tests using Maven --
run from Project Root Directory
   mvn clean test

# Test Observations

1. Login Error message "Invalid password" not ideal, inline with Security Standards.
   Should be changed to "invalid Credentials" inline with OWASP Guidance

2. Summary page- Inconsistent display of size and color text between the cart and table description

3. There is some rounding issues noticed when comparing the total with the sum of individual items

# Potential Improvements For Future

  a. Configure Tests to run in Groups
  b. Configure Tests to run in paralell
