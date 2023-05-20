# Selenium project for testing e-commerce website.
### 🌐Website: https://ecommerce-playground.lambdatest.io/

### Description:
* The project uses Selenium with Java, Maven, TestNG, Docker and Selenium Grid
* Testing the website's functionalities
* Designed with POM pattern
* DDT (reading data from json files and Excel sheets)
* Running on multiple browsers
* Parallel run for test cases
* Remote execution with a Dockerized Selenium grid
* Generating Allure report, Extent report and Screenshots for failed tests


## To run this project
___
* Make sure you have Docker Desktop
* Pull the images of Selenium Grid (hub+nodes for the browsers) running these commands in your terminal
```console
pull selenium/hub
pull selenium/node-chrome  (Choose your browsers)
pull selenium/node-chrome-debug
```
* Enter the browsers in the RegressionSuite.xml file
```xml
     <test name="Chrome1 tests">
       <parameter name="BrowserName" value="chrome"></parameter>
        .
        .
    <test  name="Edge tests">
       <parameter name="BrowserName" value="Edge"></parameter>
```
### Make your Docker containers from your IDE terminal:
* change directory to the project directory
```shell
docker-compose up
```
* run the RegressionSuite.xml


#### Note: you can choose whether to run it locally or remotely from src/main/java/utils/DriverType.java
