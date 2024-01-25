FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY target/open-weather.jar /app/open-weather.jar

EXPOSE 8585

CMD ["java", "-jar", "/app/open-weather.jar"]