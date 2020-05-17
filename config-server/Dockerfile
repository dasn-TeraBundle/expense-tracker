FROM openjdk:11.0-slim-buster
MAINTAINER Nirupam

WORKDIR /opt
ADD target/config-server-0.0.1-SNAPSHOT.jar /opt
EXPOSE 8888

CMD ["java", "-jar", "/opt/config-server-0.0.1-SNAPSHOT.jar"]