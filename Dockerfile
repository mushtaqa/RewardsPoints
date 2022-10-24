FROM openjdk:8
ADD target/reward-point-docker.jar reward-point-docker.jar
ENTRYPOINT ["java","-jar","/reward-point-docker.jar"]
EXPOSE 8080