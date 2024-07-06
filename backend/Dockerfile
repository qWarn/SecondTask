FROM openjdk:21

RUN mkdir backend
WORKDIR backend

COPY backend/build/libs/backend-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]