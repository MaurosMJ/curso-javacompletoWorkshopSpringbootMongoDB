# Complete Java Course - Object-Oriented Programming - Workshop Spring Boot & MongoDB

###### @Author: MaurosMJ

<div style="text-align:center;">
    <img src="https://imgur.com/fHE7vp3.png" alt="Spring Boot Logo" width="100" height="100">
</div>

This repository is dedicated to a Spring Boot Java + MongoDB project with the following objectives:

- Understand the main differences between document-oriented and relational paradigms.
- Implement CRUD operations.
- Reflect on design decisions for a document-oriented database.
- Implement associations between objects:
  - Nested Objects
  - References
- Perform queries with Spring Data and MongoRepository.

## Index

- [Technologies](#technologies)
- [API Documentation](#api-documentation)
- [Architecture](#architecture)
- [Worknotes & Commits](#worknotes--commits)
- [Credits](#credits)
- [Swagger](#swagger)

## Technologies

<div style="text-align:center;">
    <img src="https://imgur.com/WRaMdCh.png" alt="Technologies">
</div>

- Java
- Spring Boot
- Tomcat
- MongoDB
- Maven

## More Information

**Course Link:** [Udemy Java Complete Course](https://www.udemy.com/course/java-curso-completo)  
**Section 24:** Project: Restful API with Spring Boot and MongoDB (Web services + NoSQL)

## API Documentation

The full API documentation (SWAGGER) can be found [HERE](https://maurosmj.github.io/curso-javacompletoWorkshopSpringbootMongoDB/)

## Architecture

### Domain Model

Core business entities and their relationships:

<div style="text-align:center;">
    <img src="https://imgur.com/15ZvJML.png" alt="Domain Model">
</div>

<div style="text-align:center;">
    <img src="https://imgur.com/50RJ633.png" alt="Domain Model Diagram">
</div>

### Logical Layers

- **Resource Layer:** Handles incoming HTTP requests and responses.
- **Service Layer:** Contains business logic and acts as a bridge between the resource and repository layers.
- **Repository Layer:** Manages data access and persistence.

<div style="text-align:center;">
    <img src="https://imgur.com/hiuckcd.png" alt="Logical Layers">
</div>

## Worknotes & Commits

### Worknote #1 - Entity User and REST working
Commit hash: [d41d3bb60fbc3e3963ec774fc32646473dbd6280](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/d41d3bb60fbc3e3963ec774fc32646473dbd6280)  
**Checklist:**
* In the domain subpackage, create the User class
* In the resources subpackage, create a UserResource class and implement the default GET endpoint

### Worknote #2 - Connecting to MongoDB with repository and service
Commit hash: [1b7cba325b067284b2118ce2d22a1894256b34d5](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/1b7cba325b067284b2118ce2d22a1894256b34d5)  
**Checklist:**
* In the repository package, create the UserRepository interface
* In the services package, create the UserService class with a findAll method
* In User, add the @Document and @Id annotations to indicate that it is a MongoDB collection
* In UserResource, refactor the code to use UserService for user retrieval
* In application.properties, add the database connection details:
  * spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
* Start MongoDB (mongod command)
* Using MongoDB Compass:
  * Create database: workshop_mongo
  * Create collection: user
  * Manually create some user documents
* Test the /users endpoint

### Worknote #3 - Database instantiation operation
Commit hash: [77ff154527cf47d61ce07f3057de441ce1b31e2f](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/77ff154527cf47d61ce07f3057de441ce1b31e2f)  
**Checklist:**
* In the config subpackage, create a configuration class Instantiation that implements CommandLineRunner

### Worknote #4 - Using DTO pattern to return users
Commit hash: [5d99017ed464ea17461c1ccf578449ec723b9fe4](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/5d99017ed464ea17461c1ccf578449ec723b9fe4)  
**Checklist:**
* In the dto subpackage, create UserDTO
* In UserResource, refactor the findAll method

### Worknote #5 - Getting a user by ID
Commit hash: [29a7692547e47d5ebff4ab94be34d36dcf45c830](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/29a7692547e47d5ebff4ab94be34d36dcf45c830)  
**Checklist:**
* In the service.exception subpackage, create ObjectNotFoundException
* In UserService, implement the findById method
* In UserResource, implement the findById method (returning DTO)
* In the resources.exception subpackage, create the following classes:
  * StandardError
  * ResourceExceptionHandler

### Worknote #6 - User insertion with POST
Commit hash: [dbe7f6b1256b2c99a2f6cca93e3bb334b28be740](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/dbe7f6b1256b2c99a2f6cca93e3bb334b28be740)  
**Checklist:**
* In UserService, implement the insert and fromDTO methods
* In UserResource, implement the insert method

### Worknote #7 - User deletion with DELETE
Commit hash: [62aef778f53d3fd5e5c785ab696e25017f827c1c](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/62aef778f53d3fd5e5c785ab696e25017f827c1c)  
**Checklist:**
* In UserService, implement the delete method
* In UserResource, implement the delete method

### Worknote #8 - User update with PUT
Commit hash: [53dde92b6cc58a29925b46a502bbfce9b74b658b](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/53dde92b6cc58a29925b46a502bbfce9b74b658b)  
**Checklist:**
* In UserService, implement the update and updateData methods
* In UserResource, implement the update method

### Worknote #9 - Creating Post entity with nested User
Commit hash: [433948b4d59b6a169e3cfd564c8599afe2987d93](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/433948b4d59b6a169e3cfd564c8599afe2987d93)  
**Checklist:**
* Create the Post class
* Create PostRepository
* Insert some posts in the initial database load

### Worknote #10 - Projecting author data with DTO
Commit hash: [2b41e2a79b8e4feb5324199f36da7b710e7c0a0b](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/2b41e2a79b8e4feb5324199f36da7b710e7c0a0b)  
**Checklist:**
* Create AuthorDTO
* Refactor Post
* Refactor the initial database load
  * **IMPORTANT:** now it is necessary to persist the User objects before relating them

### Worknote #11 - Referencing user posts
Commit hash: [7192698ceec3da2be5b75304dcb1bbcf497e8b62](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/7192698ceec3da2be5b75304dcb1bbcf497e8b62)  
**Checklist:**
* In User, create the "posts" attribute using @DBRef
  * Suggestion: include the parameter (lazy = true)
* Refactor the initial database load, including post associations

### Worknote #12 - Endpoint to return user posts
Commit hash: [bb04d1a9a2b3b4ec9348c22dcb4c63241f2d61c7](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/bb04d1a9a2b3b4ec9348c22dcb4c63241f2d61c7)  
**Checklist:**
* In UserResource, implement the endpoint /users/{id}/posts

### Worknote #13 - Post retrieval by ID
Commit hash: [30e335c2f58926a9c7a181f45795dc19f50a175f](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/30e335c2f58926a9c7a181f45795dc19f50a175f)  
**Checklist:**
* In PostService, implement the findById method
* In PostResource, implement the findById method

### Worknote #14 - Adding Comments to Posts
Commit hash: [1d687bb91194cd239b6f5537bf4123e53b76a2aa](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/1d687bb91194cd239b6f5537bf4123e53b76a2aa)  
**Checklist:**
* Create `CommentDTO`
* In `Post`, include a list of `CommentDTO`
* Refactor the initial database load to include some comments in the posts  

### Worknote #15 - Simple Query with Query Methods
Commit hash: [2bfa8425c6a8173fde4a7cc6f2affece4eebac92](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/2bfa8425c6a8173fde4a7cc6f2affece4eebac92)  
**Checklist:**
* In `PostRepository`, create the search method
* In `PostService`, create the search method
* In the `resources.util` subpackage, create a utility class `URL` with a method to decode URL parameters
* In `PostResource`, implement the endpoint

### Worknote #16 - Simple Query with @Query
Commit hash: [a82f02626a95d30be6492f461c4b5d81d4f0b271](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/a82f02626a95d30be6492f461c4b5d81d4f0b271)  
**Checklist:**
* In `PostRepository`, implement an alternative query
* In `PostService`, update the query call

### Worknote #17 - Query with Multiple Criteria
Commit hash: [a0a471a3c1b4d4ea60a6f10a701dd9a49d69344e](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringbootMongoDB/commit/a0a471a3c1b4d4ea60a6f10a701dd9a49d69344e)  
**Checklist:**
* In `PostRepository`, create the query method
* In `PostService`, create the query method
* In the utility class `URL`, create methods to handle received dates
* In `PostResource`, implement the endpoint

## Credits

This repository is maintained by [MaurosMJ](https://github.com/MaurosMJ). The projects are based on the 'Java COMPLETO Programação Orientada a Objetos + Projetos' course.

## Swagger:

```yaml
openapi: 3.0.0
info:
  title: Workshop Mongo API
  description: API for managing posts and users
  version: 1.0.0
servers:
  - url: /posts
  - url: /users
paths:
  /posts/{id}:
    get:
      summary: Find a post by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Success
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Post'
  /posts/titlesearch:
    get:
      summary: Find posts by title
      parameters:
        - name: text
          in: query
          required: false
          schema:
            type: string
            default: ""
      responses:
        '200':
          description: Success
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Post'
  /posts/fullsearch:
    get:
      summary: Find posts by text and date range
      parameters:
        - name: text
          in: query
          required: false
          schema:
            type: string
            default: ""
        - name: minDate
          in: query
          required: false
          schema:
            type: string
            format: date
            default: ""
        - name: maxDate
          in: query
          required: false
          schema:
            type: string
            format: date
            default: ""
      responses:
        '200':
          description: Success
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Post'
  /users:
    get:
      summary: List all users
      responses:
        '200':
          description: Success
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/UserDTO'
    post:
      summary: Insert a new user
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/UserDTO'
      responses:
        '201':
          description: User created
  /users/{id}:
    get:
      summary: Find a user by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Success
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/User'
    delete:
      summary: Delete a user by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '204':
          description: User deleted
    put:
      summary: Update a user by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/UserDTO'
      responses:
        '204':
          description: User updated
  /users/{id}/posts:
    get:
      summary: List all posts of a user
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Success
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Post'
components:
  schemas:
    Post:
      type: object
      properties:
        id:
          type: string
        title:
          type: string
        body:
          type: string
        author:
          $ref: '#/components/schemas/User'
        date:
          type: string
          format: date
    User:
      type: object
      properties:
        id:
          type: string
        name:
          type: string
        email:
          type: string
        posts:
          type: array
          items:
            $ref: '#/components/schemas/Post'
    UserDTO:
      type: object
      properties:
        id:
          type: string
        name:
          type: string
        email:
          type: string
