FROM openjdk:17
WORKDIR /usr/src/app
COPY ./jar/check-in-api-1.0.jar check-in-api-1.0.jar
CMD ["java","$JAVA_OPTS","-jar","check-in-api-1.0.jar","-Dserver.port=$PORT","$JAR_OPTS"]