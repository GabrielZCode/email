FROM maven:3.8.6
WORKDIR /usr/src/app/
COPY . .
WORKDIR /usr/src/app/WebFlux/Mail
RUN mvn clean package
EXPOSE 8080
CMD java -jar ./target/Mail-0.0.1-SNAPSHOT.jar

