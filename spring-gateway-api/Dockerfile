FROM openjdk:11.0.3-jdk-slim-stretch
ADD ./target/spring-gateway-api-0.0.1-SNAPSHOT.jar /app/microServices/spring-gateway-api-0.0.1-SNAPSHOT.jar
WORKDIR app/microServices
ENTRYPOINT ["java","-jar","spring-gateway-api-0.0.1-SNAPSHOT.jar"]
