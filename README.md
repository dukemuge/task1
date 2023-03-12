# A lending platform task by Pezesha Ltd

## Introduction

This project helps us to understand the basic working of Bank accounts. Some of the functionalities implemented are
- Account creation
- View Account  details
- Transactions between two accounts


**Back-end:** Java 17, Spring Boot, Spring Data, Spring Security, Hibernate, PostgreSQL, Maven, Log4j

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

 you can run the app without packaging it using -
```bash
    **port 9090**
```
you can run the app on 
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

# Running the project with PostgreSQL

This project uses an  postgresql database so that you don't have to install a database in order to run it.  Since the project uses Spring Data and the Repository pattern, it's even fairly easy to back the same service with MongoDB. 

Here is what you would do to back the services with MySQL, for example: 

### In pom.xml add: 

```
        <dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
```

### Append this to the end of application.properties and set according to your configuration:Change the credentials to match your database: 

```
---
spring.datasource.initialization-mode=always
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=political

server.port=9090


spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update
```


# About Spring Boot  framework

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). It provides many of the usual Spring facilities that can be configured easily usually without any XML. In addition to easy set up of Spring Controllers, Spring Data, etc. Spring Boot comes with the Actuator module that gives the application the following endpoints helpful in monitoring and operating the service:

**/metrics** Shows “metrics” information for the current application.

**/health** Shows application health information.

**/info** Displays arbitrary application info.

**/configprops** Displays a collated list of all @ConfigurationProperties.

**/mappings** Displays a collated list of all @RequestMapping paths.

**/beans** Displays a complete list of all the Spring Beans in your application.

**/env** Exposes properties from Spring’s ConfigurableEnvironment.

**/trace** Displays trace information (by default the last few HTTP requests).


# About the Service

The service is just a Lending platform REST service. It uses postgreSQL database to store the data.  If your database connection properties work, you can call some REST endpoints defined in ```com.pezesha.task.controllers.*``` on **port 9090**. (see below)

More interestingly, you can start calling some of the operational endpoints (see full list below) like ```/metrics``` and ```/health``` (these are available on **port 8091**)


 
Here is what this our application demonstrates: 

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host just run using the ``java -jar`` command
* Demonstrates how to set up healthcheck, metrics, info, environment, etc. endpoints automatically on a configured port. Inject your own health / metrics info with a few lines of code.
* Writing a RESTful service using annotation: supports JSON request / response; simply use desired ``Accept`` header in your request
* Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations. 
* Automatic CRUD functionality against the data source using Spring *Repository* pattern
