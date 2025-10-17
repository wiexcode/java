# ---------------------------------------
# stage 1 (Build stage)
# ---------------------------------------

# maven - Official Image
# Safe choices for Java 8 apps:
# - Maven 3.6.3 (do not support Java 11)
# - Maven 3.8.6 (widely used, stable with Java 11)
# - Maven 3.9.9 (recommended if you want up-to-date fixes and compatibility with modern plugins)

FROM maven:3.8.6-eclipse-temurin-11 AS builder   
# 165.52 MB
#RUN apk update  && apk add  nano curl 

# ENV http_proxy=http://10.190.21.24:3128
# ENV https_proxy=http://10.190.21.24:3128
# ENV no_proxy=localhost,127.0.0.1,.example.com
# ENV HTTP_PROXY=http://10.190.21.24:3128
# ENV HTTPS_PROXY=http://10.190.21.24:3128
# ENV NO_PROXY=localhost,127.0.0.1,.example.com

# COPY settings.xml /root/.m2/settings.xml


WORKDIR /app

# Copy dependency files first for better caching
COPY . .
# COPY pom.xml ./
# COPY src ./src

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
FROM eclipse-temurin:11-jre-alpine AS runtime
# 59.04 MB

WORKDIR /app
COPY --from=builder /app/app-runner.jar ./

EXPOSE 8080
USER 1001
CMD java -jar app-runner.jar 


# # docker build -t image-java11:dev-0.0.1 . 
