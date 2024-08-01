FROM openjdk:21

COPY build/libs/user-management-app-0.0.1-SNAPSHOT.jar user-management-app.jar

ENTRYPOINT ["java", "-jar", "user-management-app.jar"]
