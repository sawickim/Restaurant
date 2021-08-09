# syntax=docker/dockerfile:1
FROM postgres
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB postgres
COPY init.sql /docker-entrypoint-initdb.d/

FROM openjdk:16-alpine3.13

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

EXPOSE 8080