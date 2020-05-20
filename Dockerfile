FROM mayan31370/openjdk-alpine-with-chinese-timezone:8-jdk
ADD chatroom-0.0.1-SNAPSHOT.jar .
EXPOSE 9200
ENTRYPOINT [ "java", "-jar", "chatroom-0.0.1-SNAPSHOT.jar" ]
