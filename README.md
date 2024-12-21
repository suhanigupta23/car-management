# Car Management System
 Created a system that allows users to manage car details, such as adding, updating, viewing, and deleting car information

A backend system to manage car inventory with features such as CRUD operations, pagination, search functionality, and more. This system allows users to add, update, delete, and retrieve car details. Additionally, it supports pagination for large datasets and global search functionality across car attributes.

## Project Structure

The project consists of a Spring Boot backend with the following key features:
- **Car Management**: CRUD operations for managing car details.
- **Pagination**: Retrieve cars in a paginated manner.
- **Global Search**: Search cars by name, model, color, or fuel type.
- **Database**: MySQL (for testing) for storing car records.

## API Endpoints

### 1. Create a Car
- **Endpoint**: `POST /api/cars`
- **Request Body (JSON)**:
  ```json
  {
    "carName": "Toyota",
    "model": "Corolla",
    "year": 2022,
    "price": 20000,
    "color": "Blue",
    "fuelType": "Petrol"
  }

### 2. Get All Cars(with pagination)
- **Endpoint**: `GET /api/cars/pagination?page=0&size=10`
- **Parameters:**
  ```page: 
  Page number (default is 0).
   ```size: Number of cars per page (default is 10).

### 3. Get Car By Id
- **Endpoint**: `GET /api/cars/{id}`
- **Path Variable:**
  ```id: ID of the car to retrieve.

### 4. Update a Car
- **Endpoint**: `PUT /api/cars/{id}`
- **Request Body (JSON)**:
  ```json
  {
    "carName": "Honda",
    "model": "Civic",
    "year": 2023,
    "price": 25000,
    "color": "Red",
    "fuelType": "Diesel"
   }

### 5. Delete A Car
- **Endpoint**: `DELETE /api/cars/{id}`
- **Path Variable:**
  ```id: ID of the car to delete.

### 6. Global Search
- **Endpoint**: `GET /api/cars/search?query=Toyota`
- **Query Parameter:**
  ```query: Search term to match against car name, model, color, or fuel type.


 ### Setup Instructions
 - **Prerequisites**
  Java 17 
  Spring Boot 
  Maven for dependencies
  MySQL Database

 - 