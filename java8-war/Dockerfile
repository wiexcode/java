# ---------------------------------------
# stage 1 (Build stage)
# ---------------------------------------

# maven - Official Image
# Safe choices for Java 8 apps:
# - Maven 3.6.3 (most widely used for Java 8)
# - Maven 3.8.6 (still Java 8 compatible, newer)

# FROM imageregistry.bankmegadev.com:5000/maven:3.8.6-eclipse-temurin-8 AS builder 
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




# ---------------------------------------
# if use stage 2 (runner)
# ---------------------------------------

# # Runtime stage with minimal base image
# jetty - Official Image
# FROM  imageregistry.bankmegadev.com:5000/jetty:9.4.58-jdk8 AS runner
FROM jetty:9.4.58-jdk8 AS runtime
COPY --from=builder --chown=jetty:jetty /build/target/*.war /var/lib/jetty/webapps/ROOT.war

# EXPOSE 8080
# USER jetty
# USER 999

# ENTRYPOINT ["/docker-entrypoint.sh"]
# CMD ["java" "-jar" "/usr/local/jetty/start.jar"]


# docker build -t java8-war:dev-0.0.1 .

