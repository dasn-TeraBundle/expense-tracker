FROM openjdk:11.0-slim-buster
MAINTAINER Nirupam

WORKDIR /opt
ADD target/expense-service-0.0.1-SNAPSHOT.jar /opt
EXPOSE 8001

CMD ["java", "-jar", "-Dspring.profiles.active=${PROFILE}", "-Dspring.cloud.config.uri=${CONFIG_URI}", "/opt/expense-service-0.0.1-SNAPSHOT.jar"]