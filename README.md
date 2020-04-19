![spring boot mongodb](https://miro.medium.com/max/862/0*KTnIxK9FJ2dkrbsL)
# spring-boot-crud-mongodb-cloud
build spring boot CRUD mongoDB Cloud

#### Prepared Encironment
* Install JDK 8 or more [Download & Install](https://www.oracle.com/java/technologies/javase-downloads.html)
* Install Gradle & Maven [Download & Install](https://mkyong.com/maven/how-to-install-maven-in-windows/)
* Setup Environment for command line using


#### Clone spring boot project
```bash 
$ git clone https://github.com/sutin1234/spring-boot-crud-mongodb-cloud.git proj-name
$ cd proj-name
```

#### Custom mongodb configurations
```bash
 #see src/main/resources/application.properties 
 spring.data.mongodb.uri=mongodb-uri
 ```

#### Build & Serve
 ```bash
 $ mvn spring-boot:run 
 $ serve on http://localhost:8080/api/customers
 ```

 #### Build & Package jar file
 ```bash
 $ mvn package #see target folder
 ```