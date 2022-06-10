FROM maven:3.8.5-openjdk-8 AS BUILD_STAGE

COPY ./ ./

RUN mvn clean package

FROM openjdk:8-jre

COPY --from=BUILD_STAGE /target/P1_EmployeeReimbursement-0.0.1-SNAPSHOT-jar-with-dependencies.jar /demo.jar

CMD ["java","-jar","/demo.jar"]
