FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8
ADD ./target/sso-client2.jar /app.jar
VOLUME /tmp
EXPOSE 8060
ENTRYPOINT ["java","-jar","/app.jar"]