FROM java:8
MAINTAINER Lei Mei
COPY ./target/backend-service-0.0.1-SNAPSHOT.jar /deployments/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/deployments/app.jar"]