FROM openjdk:8-alpine
VOLUME /tmp
ADD ./target/group06-api-core-0.0.1-SNAPSHOT.jar /app.jar
ENV TZ=Asia/Shanghai
EXPOSE 9004
ENTRYPOINT ["java","-jar","/app.jar"]
