
# Java Backend Task Overview

This project focuses on building a Java backend application using the Spring Boot framework. The objective is to develop a robust system for managing user data through a set of RESTful APIs. The application will handle user creation, retrieval, deletion, and updating operations, ensuring data integrity, security, and efficiency throughout the process.



## Features

- RESTful Endpoints: The application provides RESTful APIs for creating, retrieving, updating, and deleting user records.
- Logging: Logging functionality is implemented using the SLF4J logger framework to track application events and errors.
- Custom Exception Handling: Custom exception handling is implemented for each endpoint to provide meaningful error messages and improve error traceability.

- Validation: Input data validation is enforced using Spring Starter Validation to ensure the integrity and validity of user-provided data.

- Bulk Updation: Bulk updation functionality is implemented in accordance with project guidelines to efficiently update user records when necessary.





## Technologies Used 



```bash
 Java: Version 17
Spring Boot: Version 3.2.5
```



## Installation Guide 



```bash
 Steps
-
1.Clone the Repository:
git clone https://github.com/satyamkodale/DailypeTask.git
2.Navigate to the Project Directory:
cd DailypeTask
3.Build the project 
mvn clean install
4.Run Application 
mvn spring-boot:run

```


## Api endpoints 
1.Create User
-

- Description: Creates a new user in the system.
- HTTP Method: POST
- Endpoint: /users/create_user

```bash
Request Body 
{
    "userFullName": "Final User 1",
    "userEmail": "finaluser1@gmail.com",
    "userMobNum": "7218267502",
    "userPanNum": "ABCDE1234F",
    "userPassword": "FinalUser1@123"
}
```
```bash
Response 
{
    "userId": "bbadd28d-d6ba-4576-b360-84da35e24183",
    "userFullName": "Final User 1",
    "userEmail": "finaluser1@gmail.com",
    "userMobNum": "7218267502",
    "userPanNum": "ABCDE1234F",
    "userPassword": "FinalUser1@123",
    "createdAt": "2024-05-16T11:33:14.9896388",
    "updatedAt": "2024-05-16T11:33:14.9896388",
    "manager": null,
    "active": true
}
```


![Screenshot (391)](https://github.com/satyamkodale/DailypeTask/assets/86245375/4c0333c1-9a4d-483f-be2c-433a357c2900)


```bash
if validation fails -
{
"defaultMessage": "Invalid mobile number",
            "objectName": "userDto",
            "field": "userMobNum",
            "rejectedValue": "9876589",
            "bindingFailure": false,
            "code": "Pattern"
}
```

![Screenshot (390)](https://github.com/satyamkodale/DailypeTask/assets/86245375/8a4d1e96-16f7-4e8a-bbc0-b88394c7ca60)


2.Create User with Manager
-
- Description: Creates a new user with a  specified manager.
- HTTP Method: POST
- Endpoint: /users/create_user/{managerId}
- Request Body: Same as the Create User endpoint
- Response:  JSON Response with success  


![Screenshot (392)](https://github.com/satyamkodale/DailypeTask/assets/86245375/c709ad8a-a5c8-440a-aeab-821ff042ec93)

```bash
failure scenarios
	{
    "message": "Manager with ID e7837fd1-648f-453e-a2ea-fedb0d154e0 not found or inactive",
    "success": true,
	  "status": "NOT_FOUND"
}
```

![Screenshot (393)](https://github.com/satyamkodale/DailypeTask/assets/86245375/2b738c05-9302-4aae-9577-1bb94d9699ab)


3.Get All Users
-
- Description: Retrieves all users from the system.
- HTTP Method: GET
- Endpoint: /users/get_users
- Response: Returns a list of all user data.
  
![Screenshot (394)](https://github.com/satyamkodale/DailypeTask/assets/86245375/64f95546-00e6-4516-acef-37ab8bdff136)

![Screenshot (395)](https://github.com/satyamkodale/DailypeTask/assets/86245375/55ac074a-620e-4267-9761-1a56b015a6d9)

3.Get All Users of Manager
-
-	Description: Retrieves all users managed by a specified manager.
-	HTTP Method: GET
-	Endpoint: /users/get_users/ofManager/{managerId}
-	Response: Returns a list of user data managed by the specified manager.


![Screenshot (396)](https://github.com/satyamkodale/DailypeTask/assets/86245375/d15ab532-a98c-49ba-beec-2067a8b259b8)

![Screenshot (397)](https://github.com/satyamkodale/DailypeTask/assets/86245375/7c84016b-c06d-4c98-b123-fd051fff020a)



4.Get User by User ID
-
- Description: Retrieves a user by their user ID.
- HTTP Method: GET
- Endpoint: /users/get_users/userId/{userId}
- Response: Returns the user data with the specified user ID.
  
  ![Screenshot (398)](https://github.com/satyamkodale/DailypeTask/assets/86245375/7784fafd-35d0-440f-ac8e-e571b33911ae)

```bash 
failure scenarios
{
	    "message": "User Not found  with ID given id ",
	    "success": true,
        "status": "NOT_FOUND"
}
```

5.Get User by Mobile Number
-
-	Description: Retrieves a user by their mobile number.
-	HTTP Method: GET
-	Endpoint: /users/get_users/userMobNum/{mobNum}
-	Response: Returns the user data with the specified mobile number else failure message.

  ![Screenshot (399)](https://github.com/satyamkodale/DailypeTask/assets/86245375/40783a86-52b3-4802-bfdc-5672f0e94edc)

6.Delete User
-
-	Description: Deletes a user by their user ID.
-	HTTP Method: DELETE
-	Endpoint: /users/delete_user/{userId}
-	Response: Returns a success message upon successful deletion.

![Screenshot (400)](https://github.com/satyamkodale/DailypeTask/assets/86245375/a6f03b42-89ae-4f24-a5a4-2c8974e5e9d1)

7.Update User
-
-	Description: Updates user records in the system.
 - HTTP Method: POST
-	Endpoint: /users/update_user.

``` bash 
{
    "user_ids": ["user_Id1","user_Id2"],
    "update_data": {
        "manager_id": "manager_id"
    }
}
```
```bash 
Response: Returns a success message upon successful user update
{
    "message": "Users updated successfully",
    "success": true,
    "status": "OK"
}
```

![Screenshot (401)](https://github.com/satyamkodale/DailypeTask/assets/86245375/bd577492-e34e-4b87-bdac-0eef5fa6f2ad)

Error Handling:
-
- 1.If the provided manager ID is incorrect or not found:
Message: "Manager not found"
- 2.If some user IDs do not exist:
Message: "Some user IDs do not exist"
- 3.If the user is trying to update fields other than the manager ID:
Message: "Bulk update can only update manager_id"



8.Create Manager 
-
- Description: Creates a new manager .
- HTTP Method: POST
- Endpoint: /manager/create
- Request Body: 
```bash
{
    "managerName": "BulkUpdateManager2",
    "managerEmail": "BulkUpdateManager2@gmail.com",
    "managerPassword": "BulkUpdateManager2@123"
   
}
```
- Response:  JSON Response with success  

![Screenshot (388)](https://github.com/satyamkodale/DailypeTask/assets/86245375/2bd10800-a9e0-4c0c-9732-1648b50f51a2)

9.Update manager's active status
-
- Description: Update manager active status .
- HTTP Method: POST
- Endpoint: /manager/update/e7837fd1-648f-453e-a2ea-fedb0d154e07
```bash
- Request Body:
{
    "isActive":"false"
}
```
![Screenshot (389)](https://github.com/satyamkodale/DailypeTask/assets/86245375/7b3b6ffb-8fe1-46dc-be61-fc98a6eadb47)







