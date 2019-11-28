FROM maven:latest
WORKDIR /home/app
COPY . /home/app
RUN mvn -B dependency:resolve dependency:resolve-plugins
RUN mvn clean install
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/target/rest-1.0-SNAPSHOT.jar"]