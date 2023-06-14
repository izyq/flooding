FROM openjdk:8-alpine
VOLUME /tmp
ADD ./target/waterflood-consumer-9004-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 9004
ENTRYPOINT ["java","-jar","/app.jar"]
