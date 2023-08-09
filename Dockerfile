#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /Thesigan/Selenium/Dell_project
COPY pom.xml /Thesigan/Selenium/Dell_project/pom.xml
RUN mvn -f pom.xml clean install
ENTRYPOINT ["mvn"]
CMD ["clean","install","-Dsurefire.suiteXmlFiles=/Cucumbertestng.xml"]

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /Thesigan/Selenium/Dell_project/target/*.jar my-maven-docker-project.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","my-maven-docker-project.jar"]
