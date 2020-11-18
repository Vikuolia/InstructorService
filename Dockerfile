FROM openjdk:11-jre
WORKDIR D: /3 курс/ТРСПО/lab3/instructor/out/artifacts/instructor_jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","/app.jar"]
