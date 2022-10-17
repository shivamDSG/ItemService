FROM openjdk:11
ADD build/libs/itemService-0.0.1-SNAPSHOT.jar itemService-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
ENTRYPOINT ["java","-jar","/itemService-0.0.1-SNAPSHOT.jar"]