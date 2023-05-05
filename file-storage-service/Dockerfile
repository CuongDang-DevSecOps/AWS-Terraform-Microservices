FROM openjdk:17-alpine

RUN mkdir -p /usr/app/

COPY target/*.jar /usr/app/application.jar

RUN chmod +x /usr/app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/app/application.jar"]