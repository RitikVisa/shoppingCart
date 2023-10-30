

FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
COPY --from=build /target/shoppingCart-0.0.1-SNAPSHOT.jar shoppingCart.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "shoppingCart.jar"]

