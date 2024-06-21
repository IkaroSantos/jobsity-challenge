FROM openjdk:17.0-jdk

WORKDIR /app

COPY ./build/libs/task-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]