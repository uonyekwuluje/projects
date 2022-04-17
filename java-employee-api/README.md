# CRUD API for Employee Application
This small application is geared at testing and exploring CRUD concepts using Springboot.

## Requirements
* Docker
* Docker Compose
* Kubernetes
* Postgres

## Build Operations & Tasks 
Build and run
```
# Maven Clean & Install
mvn clean install

# Maven Install, Test Compile with Profile
mvn -P default install
mvn -P prod install

# Check Active Profiles
mvn help:active-profiles
```




## Test Application
```
# Start Application
./mvnw spring-boot:run

# Start with profiles
./mvnw spring-boot:run -Dspring-boot.run.profiles=default
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
OR
java -Dspring.profiles.active=dev -jar target/ops-0.0.1-SNAPSHOT.jar


# Test Version
curl -s 'localhost:8082/api/version' | jq .

# List Employees
curl -s 'localhost:8080/api/list' | jq .

# Search employee by ID
curl http://localhost:8080/api/employee/2

# Create Employees
curl -X POST http://localhost:8080/api/create -H 'Content-Type: application/json' \
-d '{"employeeID":"empl-003","employeeFirstName":"Mark", "employeeLastName":"Rafalo"}'

# Update Employee
curl -X PUT http://localhost:8080/api/employee/4 -H 'Content-Type: application/json' \
-d '{"employeeID":"empl-002","employeeFirstName":"Benedict", "employeeLastName":"Cumberbatch"}'

# Delete Employees
curl -X DELETE http://localhost:8080/api/employee/1
```


## Reference Links
* [Spring Boot Quickstart](https://start.spring.io)
