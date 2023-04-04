# Parabank Tech Test

## Pre-requisites
Please make sure you have the following installed:
* Java 17
* Maven
* Chromedriver
* IDE such as IntelliJ

## How to run tests

* Clone repository locally
* Change directory to project
* Run following command in terminal window: 
> mvn clean install -DbrowserProfile=chrome -Dcucumber.options="--tags @parabank"

## Reports
### Accessibility Reports
* a11y reports are generated in ./accessibility/report
* Open report in browser of choice for web view

### Surefire Test Report
* to create a test report run the following command:
>mvn surefire-report:report 
* Reports output to target/site
* Open report in browser of choice for web view



