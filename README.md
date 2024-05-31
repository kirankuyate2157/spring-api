# CRUD API for Firebase Database

This repository contains a Spring Boot application for a CRUD API that interacts with a Firebase Database to manage users and their subject marks.

###### API base endpoint : `https://spring-firebase-api.onrender.com`

### Endpoints

#### Health Check

- **URL:** `/users/health`
- **Method:** `GET`
- **Success Response:**
  - **Code:** 200 OK
  - **Content:** 
    ```json
    {
      "message": "Server working well 🔃✅ 🔥💫"
    }
    ```

#### Create a User

- **URL:** `/users/create`
- **Method:** `POST`
- **Headers:** 
  - `Content-Type: application/json`
- **Body Parameters:**
  ```json
  {
    "name": "string",
    "subjectMarks": {
      "math": "number",
      "physics": "number",
      "chemistry": "number",
      "biology": "number",
      "marathi": "number",
      "english": "number"
    }
  }
  ```
- **Success Response:**
  - **Code:** 201 Created
  - **Content:** 
    ```json
    {
      "id": "string",
      "name": "string",
      "subjectMarks": {
        "math": "number",
        "physics": "number",
        "chemistry": "number",
        "biology": "number",
        "marathi": "number",
        "english": "number"
      }
    }
    ```
- **Error Response:**
  - **Code:** 400 Bad Request
  - **Content:** 
    ```json
    {
      "error": "Error message"
    }
    ```

#### Retrieve All Users

- **URL:** `/users/all`
- **Method:** `GET`
- **Success Response:**
  - **Code:** 200 OK
  - **Content:** 
    ```json
    [
      {
        "id": "string",
        "name": "string",
        "subjectMarks": {
          "math": "number",
          "physics": "number",
          "chemistry": "number",
          "biology": "number",
          "marathi": "number",
          "english": "number"
        }
      },
    ]
    ```

#### Retrieve a User

- **URL:** `/users/{userId}`
- **Method:** `GET`
- **URL Parameters:** 
  - `userId=[string]` (ID of the user to retrieve)
- **Success Response:**
  - **Code:** 200 OK
  - **Content:** 
    ```json
    {
      "id": "string",
      "name": "string",
      "subjectMarks": {
        "math": "number",
        "physics": "number",
        "chemistry": "number",
        "biology": "number",
        "marathi": "number",
        "english": "number"
      }
    }
    ```
- **Error Response:**
  - **Code:** 404 Not Found
  - **Content:** 
    ```json
    {
      "error": "User not found"
    }
    ```

#### Update a User

- **URL:** `/users/update/{id}`
- **Method:** `PATCH`
- **Headers:** 
  - `Content-Type: application/json`
- **URL Parameters:** 
  - `id=[string]` (ID of the user to update)
- **Body Parameters:**
  ```json
  {
    "name": "string",
    "subjectMarks": {
      "math": "number",
      "physics": "number",
      "chemistry": "number",
      "biology": "number",
      "marathi": "number",
      "english": "number"
    }
  }
  ```
- **Success Response:**
  - **Code:** 200 OK
  - **Content:** 
    ```json
    {
      "id": "string",
      "name": "string",
      "subjectMarks": {
        "math": "number",
        "physics": "number",
        "chemistry": "number",
        "biology": "number",
        "marathi": "number",
        "english": "number"
      }
    }
    ```
- **Error Response:**
  - **Code:** 400 Bad Request
  - **Content:** 
    ```json
    {
      "error": "Error message"
    }
    ```
  - **Code:** 404 Not Found
  - **Content:** 
    ```json
    {
      "error": "User not found"
    }
    ```

#### Delete a User

- **URL:** `/users/remove/{id}`
- **Method:** `DELETE`
- **URL Parameters:** 
  - `id=[string]` (ID of the user to delete)
- **Success Response:**
  - **Code:** 204 No Content
- **Error Response:**
  - **Code:** 404 Not Found
  - **Content:** 
    ```json
    {
      "error": "User not found"
    }
    ```

## Sample Requests

### Create a User
```sh
curl -X POST http://localhost:8080/users/create \
  -H "Content-Type: application/json" \
  -d '{
        "name": "John Doe",
        "subjectMarks": {
          "math": 95,
          "physics": 85,
          "chemistry": 75,
          "biology": 65,
          "marathi": 55,
          "english": 45
        }
      }'
```

### Retrieve All Users
```sh
curl -X GET http://localhost:8080/users/all
```

### Retrieve a User
```sh
curl -X GET http://localhost:8080/users/1
```

### Update a User
```sh
curl -X PATCH http://localhost:8080/users/update/1 \
  -H "Content-Type: application/json" \
  -d '{
        "name": "John Doe Updated",
        "subjectMarks": {
          "math": 98,
          "physics": 88,
          "chemistry": 78,
          "biology": 68,
          "marathi": 58,
          "english": 48
        }
      }'
```

### Delete a User
```sh
curl -X DELETE http://localhost:8080/users/remove/1
```

## Error Codes

- `400 Bad Request` - The request could not be understood or was missing required parameters.
- `401 Unauthorized` - Authentication failed or user does not have permissions for the requested operation.
- `404 Not Found` - The requested resource could not be found.
- `500 Internal Server Error` - An error occurred on the server.
