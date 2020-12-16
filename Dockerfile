FROM java:8
EXPOSE 8081
ADD /target/books-0.0.1-SNAPSHOT.jar books.jar
ENTRYPOINT ["java","jar","books.jar"]