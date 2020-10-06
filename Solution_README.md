# Solution

## Class design
The solution is structured in three main layer:

#### Repository
JPA Repository for interaction with database.
#### Service
Business Logic layer to aggregate and return repositories data.
Annotation @Service is used to inject the class in the Spring Application Context.
#### Controller
Class for expose api, each method define the service request path, http method and request params.
Each controller extends a BaseController, in which are defined the ExceptionHandlers that handles
exception thrown by low level layer returning a specific body and error code.

## Test
Execute with:

    ./gradlew test -i 
#### Integration Test
Implemented for testing database integration.

They verify if data are correctly inserted and fetched.

A dedicated datasource is defined overriding the default application.properties
    
    src/test/resources/application.properties

data.sql file for test 

    src/test/resources/data.sql
contains only the DDL scripts (in this case CREATE TABLE)

In this way, each test prepare the data required on their own, the annotation @Transactional is used
in order to rollback the db operation performed by test, ensuring the environment indipendency after each
execution. 

#### Service Test
Implemented for testing service layar methods, that usually consist in more repository interaction.
In our case the service method just call repository and return the dto object correctly filled.

#### Controller/API Test
Implemented for testing the API invocation, for example return code and response body.
MockMvc is used in order to execute the web services invocation.
