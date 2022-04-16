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
mvn clean install
```


## Test Application
```
# Start Application
./mvnw spring-boot:run

# List Employees
curl -s 'localhost:8080/api/list' | jq .

# Search employee by ID
curl http://localhost:8080/api/employee/2

# Create Employees
curl -X POST http://localhost:8080/api/create -H 'Content-Type: application/json' \
-d '{"employeeID":"empl-003","employeeFirstName":"Mark", "employeeLastName":"Rafalo"}'

# Delete Employees
curl -X DELETE http://localhost:8080/api/employee/1
```


## Reference Links
* [Spring Boot Quickstart](https://start.spring.io)
