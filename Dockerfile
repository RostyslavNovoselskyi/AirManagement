FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/air-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} air.jar

#WORKDIR /app

#COPY target/air-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","air-0.0.1-SNAPSHOT.jar"]