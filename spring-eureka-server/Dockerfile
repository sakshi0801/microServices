FROM openjdk:11.0.3-jdk-slim-stretch
ADD ./target/eureka-server-0.0.1-SNAPSHOT.jar app/microServices/eureka-server-0.0.1-SNAPSHOT.jar
WORKDIR app/microServices
ENTRYPOINT ["java","-jar","eureka-server-0.0.1-SNAPSHOT.jar"]
