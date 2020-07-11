# EXPENSE TRACKER

![Java CI with Maven](https://github.com/dasn-TeraBundle/expense-tracker/workflows/Java%20CI%20with%20Maven/badge.svg)
![Docker Image CI](https://github.com/dasn-TeraBundle/expense-tracker/workflows/Docker%20Image%20CI/badge.svg)                                                                 

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