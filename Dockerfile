# Usa una imagen base de Java
FROM openjdk:8-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/idesoft-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor se inicia
CMD ["java", "-jar", "app.jar"]
