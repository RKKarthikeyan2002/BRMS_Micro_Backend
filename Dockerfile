FROM openjdk:18
WORKDIR /app
COPY ./target/Bike_Rent_System-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Bike_Rent_System-0.0.1-SNAPSHOT.jar"]