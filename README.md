# EXPENSE TRACKER 

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/dashboard?id=dasn-TeraBundle_et-app)

![Java CI with Maven](https://github.com/dasn-TeraBundle/expense-tracker/workflows/Java%20CI%20with%20Maven/badge.svg)
![Docker Image CI](https://github.com/dasn-TeraBundle/expense-tracker/workflows/Docker%20Image%20CI/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=dasn-TeraBundle_et-app&metric=alert_status)](https://sonarcloud.io/dashboard?id=dasn-TeraBundle_et-app)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=dasn-TeraBundle_et-app&metric=bugs)](https://sonarcloud.io/dashboard?id=dasn-TeraBundle_et-app)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=dasn-TeraBundle_et-app&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=dasn-TeraBundle_et-app)
                                                              

## DESCRIPTION
This application can be used to track all expenses. Entire application is built using microservice architecture. 

### SERVICES
It is made up of multiple services listed below
* eureka - Eureka service used for service fregistration
* config-servder - This service is used to serve all configurations of the entire app.
* gateway - This service acts as a gateway to entire application
* admin-service - This service is used perform all administrative operations
* expense-service - This service is used to manage exprenses and payments

### TECH STACK

* Java 11
* Spring Boot 2.2
* Spring Cloud
  * Eureka
  * Spring Cloud Config
  * Spring Cloud Gateway
  * Feign
* Swagger
 
## REQUIREMENTS

* Java 11 and above
* Maven 3
* MongoDB

## RUN

### BUILD

Run the following command to build and package the application
```
mvn clean package
```

Run the following command to build docker imagres from packaged jars from previous step.
```
build-images
```
## CONTRIBUTIONS

* Nirupam Das