FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} micro-services-store-management-project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/micro-services-store-management-project-0.0.1-SNAPSHOT.jar"]