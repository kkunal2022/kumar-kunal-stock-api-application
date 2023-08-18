# Spring Boot Stock API Application with Docker Deployment Service
Stock API CRUD Application

### **_`**** Note - In order to run the project with Docker dependency in yaml file, please first Toggle 'Skip Test' Mode and then run the clean and package by clicking on it.`_**

This Spring Boot Microservice is created for the Stock API - CRUD Operation, along with the below core microservices concepts like: 

- [x] naming conventions
- [x] error-handling
- [x] logging: general {Slf4j}
- [x] Dockerfile

### Technology Stack Used For The Project:

- Java 17 / 11 / 8
- Spring Boot 2.7.14, Maven 3.x, Lombok 1.18
- MySql / H2the 
- Open API 3.0
- Docker
- Unit Testing

## Naming Conventions

- Project Name for the package starts with
    - Project Name: kumar-kunal-stock-api-application(Stock API Application)
    - package name: com.kunal.stock.api

- Project Name for a real service will take place below:
    - package name: com.kunal.stock.api
    - Maven Project Name: kumar-kunal-stock-api(Stock API Application)
        - jar name: api-0.0.1-SNAPSHOT.jar
    - url format: /api/stocks/1 or /api/stocks    

- Swagger Open API 3 for the Stocks Services can be accessed by the below URL, once the Spring Boot Application is up and running
  - http://localhost:8080/swagger-ui/index.html#/stock-controller/

- Postman Collections for the APIs have been placed under the resource folder of the project with name as <b> Stock.postman_collection.json </b>
- <i>Screenshots for the APIs Request via Docker Compose have been placed at the end of this file with Docker Screenshots.</i>

- 3 Unit Testing files of the application is under the test folder, which can be run directly as Junit / Integration Test.

- - Dockerfile and Docker-Compose file has been created as per the provided requirement both for the MS SQL Server and My SQL, with the below names:
- Dockerfile [To Run The JDK 14 placed under the root directory of the Spring Boot project, common both for MS SQL Server and MY SQL]
- docker-compose.yml [Specific To MS SQL Server with Spring Boot Stock-App]
- docker-compose-mysql.yml [Specific To MY SQL Server with Spring Boot Stock-App

- To Run the above Docker Files below commands and requirements must be fulfilled:
  1. <b>Docker Desktop</b> Installed locally as per the OS [https://docs.docker.com/desktop/]
  2. <b>JDK 14</b> [https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html]
  3. To build and containerize Spring Boot Application with Docker, run the below commands from the project terminal / powershell:
  - [x] docker pull mysql 
  - [x] #### **_`docker network create springboot-mysql-stocks-network**_ `
  - [x] docker network ls 
  - [x] docker images 
  - [x] docker run --name stocks-mysqldb --network springboot-mysql-stocks-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=stocks -d mysql 
  - [x] docker logs -f fda4bec1fb6b  **===>** to see the logs of the docker mysql container, screenshot attached. 
  - [x] Accessing mysql database in mysql container type the following command - **`docker exec -it fda4 bash`**
  - [x] **`mysql -u root -p followed by the password`** 
  - [x] **`docker build -t stock-springboot-restful-webservices .`**
##   - [x] **`docker run --network springboot-mysql-stocks-network --name stock-springboot-mysql-container -p 8080:8080 -d stock-springboot-restful-webservices`**
#   - [x] **`docker-compose up`**

