# Temel imaj olarak OpenJDK 21 kullanıyoruz
FROM openjdk:21

# JAR dosyasını konteynere kopyalıyoruz
COPY build/libs/user-management-app-0.0.1-SNAPSHOT.jar user-management-app.jar

# Konteyner başlatıldığında JAR dosyasını çalıştırıyoruz
ENTRYPOINT ["java", "-jar", "user-management-app.jar"]
