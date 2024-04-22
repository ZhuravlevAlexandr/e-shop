FROM openjdk:17

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} user_service.jar

ENTRYPOINT ["java", "-jar", "/user_service.jar"]