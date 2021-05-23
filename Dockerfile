FROM openjdk:16-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Durl=jdbc:mysql://mysql-host:3306/db_commerce","-Dusername=klass","-Dpassword=123456","-jar","/app.jar"]