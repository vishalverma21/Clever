# Clever

# UI Automation

This is the sample test automation task in which below test scenarios are included:

Scenario 1: Validate sorting on User Profile page
Go to CleverShuttle <br />
Enter UserName and Password <br />
Click on Login button <br />
Verify Home Page <br />
Click on working time <br />
Verify that user is redirected to working time area <br />
Click on Record working time <br />
Validate that timer is started <br />
Click on stop working time <br />
Validate that the timer is stopped <br />
        
Above scenarios are performed uk with english but we can test the same scenarios on de portal , we can add more examples as well. The focus is only on the architecture not on the test cases.

# Getting Started

Please follow below instruction to copy the project and running on your local machine for testing purpose

#### Prerequisites

Maven home: apache-maven-3.5.3

Java version: 1.8.0_201, vendor: Oracle Corporation

Chrome version: Version 103.0.5060.114 (Official Build) (64-bit)
Chrome Driver: 103.0.5060.114

Git Bash

This test was done on MAC.

# Running the tests

Given scenario is automated using selenium cucumber.
Gherkin language is used in cucumber for these scenario.

#### Below is the work flow of calling methods in this framework

Feature File >>>> Step Definition File >>>> Main File

For example: Feature file is created for Automation demo in which scenario is written in gherkin language.
This feature file calls step definition file through glue code.
Then step definition file calls main page file in which all methods are defined.

# Installation

### Linux Machine

If you’re on Fedora for example (or any closely-related RPM-based distro such as RHEL or CentOS), you can use below command to install Git:
##### $ sudo dnf install git-all

If you’re on a Debian-based distribution like Ubuntu, try apt-get:
##### $ sudo apt-get install git-all

Install Maven
#### $ sudo apt-get install maven

1. Clone the project from below location:

git@github.com:vishalverma21/Clever.git

2. Go to source folder in local machine

3. Run " mvn test " command in source folder " Thought " from your maven or git bash
mvn test

### Report

#### Extent Report - Open target folder after executing the project and open extent.html

## Screenshot
Screenshots are available in target directory after each execution
