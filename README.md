
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

2.Create User with Manager
-
- Description: Creates a new user with a  specified manager.
- HTTP Method: POST
- Endpoint: /users/create_user/{managerId}
- Request Body: Same as the Create User endpoint
- Response:  JSON Response with success  


```bash
failure scenarios
	{
    "message": "Manager with ID e7837fd1-648f-453e-a2ea-fedb0d154e0 not found or inactive",
    "success": true,
	  "status": "NOT_FOUND"
}
```

3.Get All Users
-
- Description: Retrieves all users from the system.
- HTTP Method: GET
- Endpoint: /users/get_users
- Response: Returns a list of all user data.

3.Get All Users of Manager
-
-	Description: Retrieves all users managed by a specified manager.
-	HTTP Method: GET
-	Endpoint: /users/get_users/ofManager/{managerId}
-	Response: Returns a list of user data managed by the specified manager.


4.Get User by User ID
-
- Description: Retrieves a user by their user ID.
- HTTP Method: GET
- Endpoint: /users/get_users/userId/{userId}
- Response: Returns the user data with the specified user ID.

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

6.Delete User
-
-	Description: Deletes a user by their user ID.
-	HTTP Method: DELETE
-	Endpoint: /users/delete_user/{userId}
-	Response: Returns a success message upon successful deletion.


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







