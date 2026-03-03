#INSTALLATION OF THE OPERATING SYSTEM
FROM eclipse-temurin:17-jdk
COPY target/gateway-server-0.0.1-SNAPSHOT.jar gateway-server.jar
EXPOSE 9097
ENTRYPOINT ["java", "-jar", "gateway-server.jar"]