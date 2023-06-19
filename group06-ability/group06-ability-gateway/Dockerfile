FROM openjdk:8-alpine
VOLUME /tmp
ADD ./target/waterflood-gateway-9001-0.0.1-SNAPSHOT.jar /app.jar
ENV TZ=Asia/Shanghai
EXPOSE 9010
ENTRYPOINT ["java","-jar","/app.jar"]