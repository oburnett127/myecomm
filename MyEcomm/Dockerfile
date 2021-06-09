#FROM docker pull maven:3.8.1-openjdk-11-slim AS builder
FROM maven:3.8.1-openjdk-8-slim AS builder
WORKDIR /jar
COPY ./MyEcomm/pom.xml ./pom.xml
COPY ./MyEcomm/src/ ./src
COPY ./MyEcomm/WebContent ./WebContent
RUN ["mvn", "-e", "--define", "skipTests", "install"]

#FROM adoptopenjdk:11.0.11_9-jdk-openj9-0.26.0-focal AS decompresor
FROM adoptopenjdk:8-jdk-openj9 AS decompresor
WORKDIR /dependency
COPY --from=builder /jar/target/*-exec.jar ./app.jar
RUN ["jar", "-xf", "app.jar"]

#FROM adoptopenjdk/openjdk11-openj9:x86_64-alpine-jre11u-nightly
FROM adoptopenjdk:8-jre-openj9
RUN ["addgroup", "--system", "spring"]
RUN ["adduser", "--system", "MyEcomm_service", "--ingroup", "spring"]
WORKDIR /app
COPY --from=decompresor /dependency/BOOT-INF/lib ./app/lib
COPY --from=decompresor /dependency/BOOT-INF/classes ./app
COPY --from=decompresor /dependency/META-INF ./app/META-INF
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.oburnett127.MyEcomm.MyEcommApplication"]
