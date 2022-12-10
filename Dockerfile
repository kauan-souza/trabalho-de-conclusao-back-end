FROM gradle:7.5-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN ./gradlew clean build --no-daemon

FROM openjdk:17-jdk-alpine
COPY --from=build /home/gradle/src/build/libs/trabalhodeconclusao-0.0.1-SNAPSHOT.jar /home/application/trabalhodeconclusao-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/home/application/trabalhodeconclusao-0.0.1-SNAPSHOT.jar"]
