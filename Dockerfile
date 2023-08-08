FROM eclispe-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar movieMania.jar
ENTRYPOINT ["java","-jar","/movieMania.jar"]
EXPOSE 8080