# ---------------------------------------
# stage 1 (Build stage)
# ---------------------------------------

# maven - Official Image
# Safe choices for Java 8 apps:
# - Maven 3.9.0 (Minimum supported Java 21)
# - Maven 3.9.6 (widely used, stable with Java 21)
# - Maven 3.9.9 (recommended if you want up-to-date fixes and compatibility with modern plugins)

FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder   
# 178.7 MB

ENV http_proxy=http://10.190.21.24:3128
ENV https_proxy=http://10.190.21.24:3128
ENV no_proxy=localhost,127.0.0.1,.example.com
ENV HTTP_PROXY=http://10.190.21.24:3128
ENV HTTPS_PROXY=http://10.190.21.24:3128
ENV NO_PROXY=localhost,127.0.0.1,.example.com

# COPY settings.xml /root/.m2/settings.xml


RUN apk update  && apk add  nano curl 

WORKDIR /app

# Copy dependency files first for better caching
# COPY . .
COPY mvnw .
COPY pom.xml ./
COPY src ./src

# Build the application with mvn
# RUN mvn clean install -DskipTests


# Build the application with mvnw
RUN chmod +x mvnw  && ./mvnw --help
RUN ./mvnw install -DskipTests && \
    ./mvnw compile -DskipTests && \
    ./mvnw package -DskipTests 


RUN cp /app/target/*.jar app-runner.jar

# EXPOSE 8080
# USER 1001
# CMD java -jar app-runner.jar 



# ---------------------------------------
# if use stage 2 (runner)
# ---------------------------------------

# # Runtime stage with minimal base image
# eclipse-temurin - Official Image
FROM eclipse-temurin:21-jre-alpine AS runtime
# 69.83 MB

WORKDIR /app
COPY --from=builder app-runner.jar ./

EXPOSE 8080
USER 1001
CMD java -jar app-runner.jar 


# # docker build -t image-java21:dev-0.0.1 . 