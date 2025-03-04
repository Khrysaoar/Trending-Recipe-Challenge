# Trending Recipes API

## Overview
This is a Java Spring Boot application that provides two RESTful API endpoints for retrieving trending recipes. The application allows fetching all trending recipes and filtering them by difficulty level.

## Features
- **Get Trending Recipes**: Retrieve a list of trending recipes ordered by position.
- **Filter by Difficulty**: Retrieve trending recipes filtered by difficulty (**easy, medium, hard**).
- **Error Handling**: Returns an appropriate error message if difficulty is missing in the filter request.

## Endpoints

### 1️⃣ Get All Trending Recipes
- **URL:** `GET /api/recipes/trending`
- **Response:**
```json
[
  {
    "id": 1,
    "name": "Cheeseburger",
    "difficulty": "easy",
    "imageUrl": "https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg"
  }...
]
```

### 2️⃣ Get Trending Recipes by Difficulty
- **URL:** `GET /api/recipes/trending/filter?difficulty={level}`
- **Parameters:** `difficulty` (required) → `easy`, `medium`, or `hard`
- **Response:**
```json
[
  {
    "id": 1,
    "name": "Cheeseburger",
    "difficulty": "easy",
    "imageUrl": "https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg"
  },
  {
    "position": 2,
    "name": "Wagyu Burger",
    "difficulty": "medium",
    "imageUrl": "https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg"
  },
  {
    "position": 3,
    "name": "Vegan Burger",
    "difficulty": "hard",
    "imageUrl": "https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg"
  }
]
```

### 3️⃣ Missing Difficulty Parameter
- **URL:** `GET /api/recipes/trending/filter`
- **Response:**
```json
{
  "error": "A difficulty is required for filtering trending recipes"
}
```

## Installation & Setup
1. **Clone the repository:**
```sh
git clone <repository-url>
cd trending-recipes-api
```

2. **Build the application:**
```sh
mvn clean install
```

3. **Run the application:**
```sh
mvn spring-boot:run
```

4. **Access the API:**
   - Base URL: `http://localhost:8080`

## Running Tests
Unit tests are included for the controller.
```sh
mvn test
```

## Postman Collection
A Postman collection is included for testing:
- Import **`TrendingRecipesAPI.postman_collection.json`** into Postman.
- Run the requests and validate responses.

## Technologies Used
- Java Spring Boot
- Maven
- JUnit 5
- Mockito
- Postman


