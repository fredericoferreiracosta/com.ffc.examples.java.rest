FROM maven:latest
WORKDIR /home/app
COPY . /home/app
RUN mvn clean install
EXPOSE 8080
ENTRYPOINT ["mvn", "exec:java", "-Dexec.mainClass='Main'"]