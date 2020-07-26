FROM openjdk:8
EXPOSE 9091
ADD target/data-layer-docker.jar data-layer-docker.jar
ENTRYPOINT ["java","-jar","/data-layer-docker.jar"]