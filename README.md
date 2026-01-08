<p align="center"><a href="https://maven.apache.org" target="_blank"><img src="https://maven.apache.org/images/maven-logo-black-on-white.png" width="400"></a></p>


<p align="center">
<a href="https://www.apache.org/licenses/LICENSE-2.0" rel="nofollow"><img src="https://camo.githubusercontent.com/767eed69cdfdd7e38682e81bbfaa40a0ce1826b5ac841fe3de4fcd448db32961/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f6c6963656e73652f6170616368652f6d6176656e2e7376673f6c6162656c3d4c6963656e7365" alt="Apache License, Version 2.0, January 2004" data-canonical-src="https://img.shields.io/github/license/apache/maven.svg?label=License" style="max-width: 100%;"></a>
<a href="https://github.com/jvm-repo-rebuild/reproducible-central/blob/master/content/org/apache/maven/maven/README.md"><img src="https://camo.githubusercontent.com/cf0fe36b27b3f2e13da7099e76f5dcdf7762ee0419b9d9b69a732290e5a62930/68747470733a2f2f696d672e736869656c64732e696f2f656e64706f696e743f75726c3d68747470733a2f2f7261772e67697468756275736572636f6e74656e742e636f6d2f6a766d2d7265706f2d72656275696c642f726570726f64756369626c652d63656e7472616c2f6d61737465722f636f6e74656e742f6f72672f6170616368652f6d6176656e2f6d6176656e2f62616467652e6a736f6e" alt="Reproducible Builds" data-canonical-src="https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/jvm-repo-rebuild/reproducible-central/master/content/org/apache/maven/maven/badge.json" style="max-width: 100%;"></a>
</p>

## Apache Maven

Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

- [master](https://github.com/apache/maven) = 4.1.x: [![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/org.apache.maven/apache-maven)
[![Jenkins Status](https://img.shields.io/jenkins/s/https/ci-maven.apache.org/job/Maven/job/maven-box/job/maven/job/master.svg?)][build]
[![Jenkins tests](https://img.shields.io/jenkins/t/https/ci-maven.apache.org/job/Maven/job/maven-box/job/maven/job/master.svg?)][test-results]
- [4.0.x](https://github.com/apache/maven/tree/maven-4.0.x): [![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven.svg?label=Maven%20Central&versionPrefix=4.0)](https://central.sonatype.com/artifact/org.apache.maven/apache-maven)
- [3.9.x](https://github.com/apache/maven/tree/maven-3.9.x): [![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven.svg?label=Maven%20Central&versionPrefix=3.)](https://central.sonatype.com/artifact/org.apache.maven/apache-maven)


## Learning Maven

More information can be found on [Apache Maven Homepage][maven-home]. Questions related to the usage of Maven should be posted on the [Maven User List][users-list].

## Quick Build

If you want to bootstrap Maven, you'll need:
- Java 17+
- Maven 3.6.3 or later
- Run Maven, specifying a location into which the completed Maven distro should be installed:
    ```
    mvn -DdistributionTargetDir="$HOME/app/maven/apache-maven-4.1.x-SNAPSHOT" clean package
    ```

## java
java LTS

maven - Official Image
Safe choices for Java 8 apps:
- Maven 3.6.3 (most widely used for Java 8)
- Maven 3.8.6 (still Java 8 compatible, newer)

- Maven 3.6.3 (do not support Java 11)
- Maven 3.8.6 (widely used, stable with Java 11)
- Maven 3.9.9 (recommended if you want up-to-date fixes and compatibility with modern plugins)

- Maven 3.8.1 (Minimum supported Java 17)
- Maven 3.8.6 (widely used, stable with Java 17)
- Maven 3.9.9 (recommended if you want up-to-date fixes and compatibility with modern plugins)

- Maven 3.9.0 (Minimum supported Java 21)
- Maven 3.9.6 (widely used, stable with Java 21)
- Maven 3.9.9 (recommended if you want up-to-date fixes and compatibility with modern plugins)


## eclipse
eclipse-temurin - Official Image :
- maven:3.3-jdk-7
- maven:3.8.6-eclipse-temurin-8
- maven:3.8.6-eclipse-temurin-11
- maven:3.8.6-eclipse-temurin-17
- maven:3.9.6-eclipse-temurin-21-alpine
- eclipse-temurin:8-jre-alpine 
- eclipse-temurin:11-jre-alpine
- eclipse-temurin:17-jre-alpine
- eclipse-temurin:21-jre-alpine


```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=my-restapi -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn clean install -DskipTests 
mvn compile -DskipTests 
mvn package -DskipTests

# listening at localhost:3000
```















