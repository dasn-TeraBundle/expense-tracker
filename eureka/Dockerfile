FROM openjdk:11.0-slim-buster
MAINTAINER Nirupam

WORKDIR /opt
ADD target/eureka-0.0.1-SNAPSHOT.jar /opt
EXPOSE 8761

CMD ["java", "-jar", "/opt/eureka-0.0.1-SNAPSHOT.jar"]