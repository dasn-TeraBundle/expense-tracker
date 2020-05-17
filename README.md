# EXPENSE TRACKER

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
```
mvn clean package
```