# Project Title

Solution Spring Boot Rest - Without JPA

## Commands

mvn clean package spring-boot:repackage
java -jar target/solution.jar

## Example URLs

Examples for CRUD
### GET: 
```
http://localhost:8080/persona/1
```
### POST:
```http://localhost:8080/persona
	JSON:
		 	{
				"id": "0",
				"name": "Eduardo",
				"lastName": "Rojas",
				"address": "El Bosque",
				"phoneNumber": "997314624",
				"colorHair": "BLACK"
			}
```			
### PUT:
```
http://localhost:8080/persona/1
	JSON:
		 	{
				"id": "1",
				"name": "Antonio",
				"lastName": "Tejo",
				"address": "El Bosque",
				"phoneNumber": "997314624",
				"colorHair": "BROWN"
			}
```			
### DELETE:
```
http://localhost:8080/persona/1
```