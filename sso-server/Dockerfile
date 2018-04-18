FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8
ADD target/*.jar /app.jar
VOLUME /tmp
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]