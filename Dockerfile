FROM openjdk:8
ADD target/rest-world.jar rest-world.jar
ENTRYPOINT ["java", "-jar", "rest-world.jar"]

