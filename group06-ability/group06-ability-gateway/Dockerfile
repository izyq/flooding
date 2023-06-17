FROM openjdk:8-alpine
VOLUME /tmp
ADD ./target/waterflood-gateway-9001-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/app.jar"]