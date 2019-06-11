FROM openjdk:11.0.3-jdk-slim-stretch
ADD ./target/spring-config-server-0.0.1-SNAPSHOT.jar /app/microServices/spring-config-server-0.0.1-SNAPSHOT.jar
WORKDIR app/microServices
ENTRYPOINT ["java","-jar","spring-config-server-0.0.1-SNAPSHOT.jar"]
