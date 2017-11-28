FROM java:8-jre
MAINTAINER Artsiom Zeliankou

ADD build/libs/config-0.0.1-SNAPSHOT.jar /app/config.jar
CMD ["java", "-jar", "/app/config.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/health || exit 1

EXPOSE 8888
