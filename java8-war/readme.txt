https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-runner/9.4.47.v20220610/jetty-runner-9.4.47.v20220610.jar

https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/12.1.5/jetty-home-12.1.5.zip

https://dlcdn.apache.org/maven/maven-3/3.8.9/binaries/apache-maven-3.8.9-bin.tar.gz


mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=hello-world-app \
  -DarchetypeArtifactId=maven-archetype-webapp \
  -DinteractiveMode=false



## Update to Java 8
add these properties inside the <project> tag to ensure it compiles with Java 8

<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>


mvn clean
mvn compile

mvn clean package


## Run it easily (Plugin Method)
you can add a "plugin" to your pom.xml to run the app directly from Maven. Add this inside the <build><plugins> section:

<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <path>/</path>
    </configuration>
</plugin>


# run with mvn
mvn tomcat7:run

# run with jetty-runner 
java -jar jetty-runner.jar hello-world-app/target/hello-world-app.war


# run with jetty-distribution-9.4.58 (java 8)
cp target/hello-world-app.war webapps/ROOT.war
java -jar start.jar
