# ---------------------------------------
# stage 1 (Build stage)
# ---------------------------------------

# maven - Official Image
# Safe choices for Java 8 apps:
# - Maven 3.6.3 (most widely used for Java 8)
# - Maven 3.8.6 (still Java 8 compatible, newer)

FROM maven:3.8.6-eclipse-temurin-8 AS builder   
# FROM maven:3.9.8-eclipse-temurin-8 AS builder  
# 121.81 MB
#RUN apk update  && apk add  nano curl 

# ENV http_proxy=http://10.190.21.24:3128
# ENV https_proxy=http://10.190.21.24:3128
# ENV no_proxy=localhost,127.0.0.1,.example.com
# ENV HTTP_PROXY=http://10.190.21.24:3128
# ENV HTTPS_PROXY=http://10.190.21.24:3128
# ENV NO_PROXY=localhost,127.0.0.1,.example.com

# COPY settings.xml /root/.m2/settings.xml


WORKDIR /build

# Copy dependency files first for better caching
# COPY settings.xml /root/.m2/settings.xml

COPY hello-world-app/pom.xml ./
COPY hello-world-app/src ./src
# COPY lib ./lib

# Build the application with mvn
RUN mvn clean install -DskipTests && \
    mvn compile -DskipTests && \
    mvn package -DskipTests 


# Build the application with mvnw
# RUN chmod +x mvnw  && ./mvnw --help
# RUN ./mvnw install -DskipTests && \
#     ./mvnw compile -DskipTests && \
#     ./mvnw package -DskipTests 


RUN cp /build/target/hello-world-app*.jar app-runner.jar

# EXPOSE 8080
# USER 1001
# CMD java -jar app-runner.jar 



# ---------------------------------------
# if use stage 2 (runner)
# ---------------------------------------

# # Runtime stage with minimal base image
# eclipse-temurin - Official Image
FROM eclipse-temurin:8-jre-alpine AS runtime
# 59.04 MB

WORKDIR /app
COPY --from=builder /build/target/hello-world-app*.jar ./app-runner.jar

EXPOSE 8080
USER 1001
CMD java -jar app-runner.jar 


# docker build -t java8-jar:dev-0.0.1 .
