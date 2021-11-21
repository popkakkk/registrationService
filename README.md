### Registration Service


Tools used by this project
- [x] spring boot 2.6.0
- [x] spring security
- [x] authen token JWT
- [x] SQL database(MySQL)

### How to installation project

##### Required
- JAVA 17
- MAVEN
- GIT 

##### Installation step
1. git clone https://github.com/popkakkk/registrationService.git
2. git checkout main
3. install or update dependency maven from pom.xml
4. setup datasource at src/main/resources/<strong>application.properties</strong>
   - spring.datasource.url=...
   - spring.datasource.username=...
   - spring.datasource.password=...
5. go to src/main/java/com/test/patipan/<strong>RegistrationServiceApplication.java</strong> and run 

### Test API <br/>
default host:  http://localhost:8080/ <br/>
2 Restful API provide
1. <strong>register user </strong> http://localhost:8080/registration/registerUser
2. <strong>get information </strong> http://localhost:8080/registration/information



##### Example request 1  
  register user</br>
  endpoint : http://localhost:8080/registration/registerUser</br>
  headers  : </br>
             Content-Type :application/json</br>
  {</br>
    "username" : "johnc1234",</br>
    "password":"1234567",</br>
    "phoneNumber":"0801234567",</br>
    "salary":"500000",</br>
    "firstName":"john",</br>
    "lastName" : "cena" </br>
 }

 ##### Example request 2 
   - register user </br>
  endpoint : http://localhost:8080/registration/information </br>
  headers  : </br>
            Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwb3BwYXRpcGEiLCJleHAiOjE2Mzc1MTgyODAsImlhdCI6MTYzNzQ4MjI4MH0.qaSLWn4mPlke8XKAJ-PXHabrPjRYbHloBRLrbr_uID0</br>

### Document Service Design
https://drive.google.com/drive/folders/1K4oEc5UebxrADwH_wGbNd9ifmMGOLm5z?usp=sharing

