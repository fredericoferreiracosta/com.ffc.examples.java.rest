# Java REST example in Docker

This is a very simple sample on how to create a Java REST API and run it inside a Docker container.

## How to use it

After downloading the repo, you can build it via maven and run it locally by:
```
mvn clean install
mvn exec:java -Dexec.mainClass=com.ffc.examples.java.rest.Main
```

Alternatively you may run it via Java after building:

```
mvn clean install
cd target/
java -jar rest-1.0-SNAPSHOT.jar
```

## Using Docker

This repo contains a Docker file so all you got do is to build the image and run the container. No maven build is necessary:
```
docker build -t com.ffc.examples.java.rest .
docker run -d -p 8080:8080 com.ffc.examples.java.rest
```