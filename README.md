# spring-jpa-mysql-test
To build
./gradlew build

To run the spring app with H2 db. 
./gradlew bootRun

The app will insert only 10 person data during the bootup.

Here are links to test the api

  http://localhost:8080/person/all?pageNumber=0

  http://localhost:8080/person/1/

  http://localhost:8080/house/all?pageNumber=1

  http://localhost:8080/child/info?id=3

  http://localhost:8080/persons/children

T run with mysql instance make following changes
in build.gradle
//runtime('com.h2database:h2')
runtime('mysql:mysql-connector-java'

And update accoringly /demo/src/main/resources/application.properties 
