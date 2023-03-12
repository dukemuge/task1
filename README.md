# A lending platform task by Pezesha Ltd

## Introduction

This project helps us to understand the basic working of Bank accounts. Some of the functionalities implemented are
- Account creation
- Transactions between two accounts


## Prerequisites
- java 1.8.x
- maven 3.x
-

**Back-end:** Java 8, Spring Boot, Spring Data, Spring Security, Hibernate, PostgreSQL, Maven, Log4j

### Steps To Setup Backend

**1. Clone the repository**
```bash
    git clone https://github.com/dukemuge/task1
```

**2. Move to root directory of backend**

**3. Build project**
```bash
    mvn clean install
``` 

**4. Run project** 
```bash
    java -jar target/backend-0.0.1-SNAPSHOT.jar
``` 
- Alternatively, you can run the app without packaging it using -
```bash
    mvn spring-boot:run
```
  #### Explore apis in backend

The app defines following APIs. 
 
```   
    POST /api/accounts   
    GET /api/accounts/{id}
    GET /api/transfers
         
```
