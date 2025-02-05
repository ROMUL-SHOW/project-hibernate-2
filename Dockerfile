# Используем официальный образ OpenJDK 21
FROM eclipse-temurin:21-jdk

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файлы проекта в контейнер
COPY . /app

# Устанавливаем Maven
RUN apt-get update && apt-get install -y maven

# Собираем проект с помощью Maven
RUN mvn clean package -DskipTests

# Указываем путь к скомпилированному JAR-файлу (замени на свой путь, если он отличается)
CMD ["java", "-jar", "target/project-hibernate-2-1.0-SNAPSHOT.jar"]