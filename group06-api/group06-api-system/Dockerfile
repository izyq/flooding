FROM openjdk:8-alpine
VOLUME /tmp
ADD ./target/group06-api-system-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 9003
ENTRYPOINT ["java","-jar","/app.jar"]