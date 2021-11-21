# registrationService
registrationService Test 

Project use
 - spring boot 2.6.0
 - spring security
 - authen token JWT
 - SQL database(MySQL)

How to installation project

Required
- JAVA 17
- MAVEN
- GIT 

Installation step
1. git clone 
2. git checkout 
3. install or update dependency maven from pom.xml
4. setup datasource at src/main/resources/application.properties
   - spring.datasource.url=...
   - spring.datasource.username=...
   - spring.datasource.password=...
5. go to src/main/java/com/test/patipan/RegistrationServiceApplication.java and run 

Test API 
default host:  http://localhost:8080/
2 API provide
1. register user http://localhost:8080/registration/registerUser
2. get information http://localhost:8080/registration/information



example request 1  
  - register user
 endpoint : http://localhost:8080/registration/registerUser
 headers  : 
            Content-Type :application/json
 {
    "username" : "johnc1234",
    "password":"1234567",
    "phoneNumber":"0801234567",
    "salary":"500000",
    "firstName":"john",
    "lastName" : "cena"
}

example request 2 
  - register user
 endpoint : http://localhost:8080/registration/information
 headers  : 
           Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwb3BwYXRpcGEiLCJleHAiOjE2Mzc1MTgyODAsImlhdCI6MTYzNzQ4MjI4MH0.qaSLWn4mPlke8XKAJ-PXHabrPjRYbHloBRLrbr_uID0



