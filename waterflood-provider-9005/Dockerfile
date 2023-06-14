FROM openjdk:8-alpine
VOLUME /tmp
ADD ./target/waterflood-provider-9005-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 9005
EXPOSE 20880
ENTRYPOINT ["java","-jar","/app.jar"]